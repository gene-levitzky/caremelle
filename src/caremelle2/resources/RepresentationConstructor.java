package caremelle2.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import caremelle2.execution.ExecutionContext;
import caremelle2.execution.ExecutionContextFunctionCall;
import caremelle2.execution.exceptions.CaremelleBaseException;
import caremelle2.execution.exceptions.NoMatchingSignatureException;
import caremelle2.resources.ImportTreeConstructor.ImportTreeNode;
import antlr2.AntlrManager;
import antlr2.AremelleLexer;
import antlr2.AremelleParser;
import antlr2.AremelleParser.ArgumentsContext;
import antlr2.AremelleParser.AtomicExpressionContext;
import antlr2.AremelleParser.ExpressionContext;
import antlr2.AremelleParser.FunctionBodyContext;
import antlr2.AremelleParser.FunctionContext;
import antlr2.AremelleParser.ImportStatementContext;
import antlr2.AremelleParser.PatternContext;
import antlr2.AremelleParser.ProgramContext;
import antlr2.AremelleParser.RewriteRuleContext;
import antlr2.AremelleParser.SignatureContext;
import aremelle2.Argument;
import aremelle2.AtomicExpression;
import aremelle2.AtomicExpressionFunctionCall;
import aremelle2.AtomicExpressionIdentifier;
import aremelle2.AtomicExpressionLiteral;
import aremelle2.Parameter;
import aremelle2.Expression;
import aremelle2.Function;
import aremelle2.Pattern;
import aremelle2.Signature;
import aremelle2.RewriteRule;
import aremelle2.Token;
import aremelle.exceptions.CannotImportFunctionException;

/**
 * This class constructs Aremelle Program objects which may be passed to the
 * AremelleProgramExecutor for execution.
 *  
 * @author Gene
 *
 */
public class RepresentationConstructor {
	
	private final Map<String, Function> functionStore;
	private final Map<String, Scope> scopeStore;
	
	private final Argument[] arguments;

	public RepresentationConstructor(String[] args){
		arguments = new Argument[args.length];
		for (int i = 0; args != null && i < args.length; i++) {
			Expression e = new Expression(new AtomicExpression[]{
					new AtomicExpressionLiteral(args[i], -1, -1)
			}, -1, -1);
			arguments[i] = new Argument(e);
		}
		functionStore = new HashMap<String, Function>();
		scopeStore = new HashMap<String, Scope>();
	}
	
	/*
	 * Entry methods.
	 */

	public Representation build(File file) 
			throws FileNotFoundException, 
			CannotImportFunctionException, 
			IOException {
		return parse(AntlrManager.getLexer(new FileReader(file)));
	}

	public Representation build(FileReader fileReader) 
			throws CannotImportFunctionException, IOException {
		return parse(AntlrManager.getLexer(fileReader));
	}

	public Representation build(String code) 
			throws CannotImportFunctionException, IOException {
		return parse(AntlrManager.getLexer(code));
	}
	
	/*
	 * 
	 */
	
	private Function getGlobalFunction(Function func) {
		AtomicExpressionFunctionCall functionCall = new AtomicExpressionFunctionCall(func, null, arguments, -1, -1);
		Expression expr = new Expression(new AtomicExpressionFunctionCall[]{ functionCall }, -1, -1);
		Function $ = new Function("$", "$", null, expr, -1, -1);
		//addFunctionToGlobalScope($);
		functionStore.put($.getUniqueID(), $);
		return $;
	}
	
	private void addFunctionToGlobalScope(Function f) throws Exception {
		Scope global = scopeStore.get("$");
		if (global != null) {
			global.addFunction(f);
		}
		throw new Exception("Attempted to add function to global scope before global function was defined.");
	}
	
	/*public String execute(Token token, Argument[] args) throws CaremelleBaseException, NoMatchingSignatureException {
		if (token instanceof Function) {
			Function function = (Function) token;
			Function $ = getBaseFunction(function, args);
			ExecutionContext context = new ExecutionContextFunctionCall(
					new AtomicExpressionFunctionCall(function, $, args, -1, -1));
			return execute(context);
		}
		return null;
	}*/
	
	/*
	 * 
	 */

	private Representation parse(AremelleLexer lexer)
			throws CannotImportFunctionException {
		return constructRepresentation(AntlrManager.getProgramContext(lexer));
	}

	public Representation constructRepresentation(ProgramContext pc) 
			throws CannotImportFunctionException {
		
		Function mainFunction = constructFunction(pc.function());
		Function globalFunction = getGlobalFunction(mainFunction);
		
		ImportTreeNode importRoot = null;
		try {
			importRoot = ImportTreeConstructor.getImportTreeNode(pc);
		} catch (Exception e) {
			// TODO
			throw new CannotImportFunctionException("$");
		}
		
		Stack<ImportTreeNode> stackNode = new Stack<ImportTreeNode>();
		for (ImportTreeNode node : importRoot.getChildren().values()) {
			stackNode.push(node);
		}
		while (!stackNode.isEmpty()) {
			ImportTreeNode node = stackNode.pop();
			String filename = node.getName();
			ProgramContext importedContext;
			try {
				importedContext = AntlrManager.getProgramContextFromFilename(filename);
			} catch (IOException e) {
				// TODO
				throw new CannotImportFunctionException(filename);
			}
			Function importedFunction = constructFunction(importedContext.function());
			
		}
		
		AtomicExpressionFunctionCall toplevel_aefc = new AtomicExpressionFunctionCall(
				mainFunction, 
				globalFunction, 
				arguments,
				mainFunction.getLineNumber(),
				mainFunction.getColumnNumber());
		ExecutionContext initialContext = new ExecutionContextFunctionCall(toplevel_aefc);

		return new Representation(initialContext, functionStore, scopeStore);
	}


	private Function constructFunction(FunctionContext functionContext) {
		FunctionBodyContext fbc = functionContext.functionBody();
		Function[] nestedFunctions = new Function[fbc.function().size()];
		for (int i = 0; i < nestedFunctions.length; i++) {
			nestedFunctions[i] = constructFunction(fbc.function(i));
		}
		int numRules = fbc.rewriteRules() == null ? 0 : fbc.rewriteRules().rewriteRule().size();
		RewriteRule[] rules = new RewriteRule[numRules];
		for (int i = 0; i < rules.length; i++) {
			rules[i] = constructRewriteRule(fbc.rewriteRules().rewriteRule(i));
		}
		Expression expression = fbc.expression() != null ? constructExpression(fbc.expression()) : null;
		String functionName = functionContext.Identifier().getText();
		return new Function(functionName, nestedFunctions, expression, rules);
	}

	private RewriteRule constructRewriteRule(RewriteRuleContext sc) {
		Expression expression = constructExpression(sc.expression());
		Signature[] signatures = new Signature[sc.signatures().signature().size()];
		for (int i = 0; i < signatures.length; i++) {
			SignatureContext psc = sc.signatures().signature(i);
			Pattern[] patterns = new Pattern[psc.pattern().size()];
			for (int j = 0; j < patterns.length; j++) {
				patterns[j] = constructPattern(psc.pattern(j));
			}
			signatures[i] = new Signature(patterns);
		}
		return new RewriteRule(signatures, expression);
	}

	private Pattern constructPattern(PatternContext pc) {
		Parameter[] parameters = new Parameter[pc.parameter().size()];
		for (int i = 0; i < parameters.length; i++) {

			ParameterContext apc = pc.parameter(i);
			String name = null, regexp = null;
			if (apc.IdentifierParameter() != null) {
				name = apc.IdentifierParameter().getText();
			}
			else if (apc.Identifier() != null) {
				name = apc.Identifier().getText();
			}
			else if (apc.regexp() != null) {
				name = apc.regexp().Identifier() != null ? apc.regexp().Identifier().getText() : null;
				if (apc.regexp().atomicRegexp().String() != null) {
					regexp = apc.regexp().atomicRegexp().String().getText();
					regexp = regexp.substring(1, regexp.length() - 1);
				}
				else if (apc.regexp().atomicRegexp().Number() != null) {
					regexp = apc.regexp().atomicRegexp().Number().getText();
				}
			}
			parameters[i] = new Parameter(name, regexp);
		}
		return new Pattern(parameters);
	}

	private Expression constructExpression(ExpressionContext expressionContext) {
		int size = expressionContext.atomicExpression().size();
		AtomicExpression[] atomicExpressions = new AtomicExpression[size];
		for (int i = 0; i < size; i++) {
			atomicExpressions[i] = constructAtomicExpression(expressionContext.atomicExpression(i));
		}
		return new Expression(atomicExpressions);
	}

	private AtomicExpression constructAtomicExpression(AtomicExpressionContext aec) {
		if (aec.String() != null) {
			String string = aec.String().getText();
			string = string.substring(1, string.length() - 1);
			return new AtomicExpressionLiteral(string);
		}
		else if (aec.Number() != null) {
			return new AtomicExpressionLiteral(aec.Number().getText());
		}
		else if (aec.Identifier() != null) {
			return new AtomicExpressionIdentifier(aec.Identifier().getText());
		}
		else if (aec.functionCall() != null) {
			ArgumentsContext argsContext = aec.functionCall().arguments();
			int numArgs = argsContext == null ? 0 : argsContext.argument().size();
			Expression[] args = new Expression[numArgs];
			for (int i = 0; i < args.length; i++) {
				args[i] = constructExpression(argsContext.argument(i).expression());
			}
			return new AtomicExpressionFunctionCall(aec.functionCall().Identifier().getText(), args);
		}
		return null;
	}

}
