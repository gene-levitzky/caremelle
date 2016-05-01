package caremelle2.resources;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import caremelle2.execution.ExecutionContext;
import caremelle2.execution.ExecutionContextFunctionCall;
import caremelle2.resources.ImportTreeConstructor.ImportTreeNode;
import antlr2.AntlrManager;
import antlr2.AremelleLexer;
import antlr2.AremelleParser.ArgumentsContext;
import antlr2.AremelleParser.AtomicExpressionContext;
import antlr2.AremelleParser.AtomicPatternContext;
import antlr2.AremelleParser.ExpressionContext;
import antlr2.AremelleParser.FunctionBodyContext;
import antlr2.AremelleParser.FunctionContext;
import antlr2.AremelleParser.PatternContext;
import antlr2.AremelleParser.ProgramContext;
import antlr2.AremelleParser.RewriteRuleContext;
import antlr2.AremelleParser.SignatureContext;
import aremelle2.Argument;
import aremelle2.AtomicExpression;
import aremelle2.AtomicExpressionFunctionCall;
import aremelle2.AtomicExpressionIdentifier;
import aremelle2.AtomicExpressionLiteral;
import aremelle2.AtomicPattern;
import aremelle2.Expression;
import aremelle2.Function;
import aremelle2.Pattern;
import aremelle2.Signature;
import aremelle2.RewriteRule;
import aremelle.exceptions.CannotImportFunctionException;

/**
 * This class constructs Aremelle Program objects which may be passed to the
 * AremelleProgramExecutor for execution.
 *  
 * @author Gene
 *
 */
public class RepresentationConstructor {
	
	private Map<String, Function> functionStore;
	private Map<String, Scope> scopeStore;
	
	private Argument[] arguments;
	
	private final static String GLOBAL_FUNCTION_ID = "$";
	
	/*
	 * Entry methods.
	 */

	public Representation build(File file, String[] args) 
			throws FileNotFoundException, 
			CannotImportFunctionException, 
			IOException {
		init(args);
		Representation representation = parse(AntlrManager.getLexer(new FileReader(file)));
		reset();
		return representation;
	}

	public Representation build(FileReader fileReader, String[] args) 
			throws CannotImportFunctionException, IOException {
		init(args);
		Representation representation = parse(AntlrManager.getLexer(fileReader));
		reset();
		return representation;
	}

	public Representation build(String code, String[] args) 
			throws CannotImportFunctionException, IOException {
		init(args);
		Representation representation = parse(AntlrManager.getLexer(code));
		reset();
		return representation;
	}
	
	/*
	 * 
	 */
	
	private void init(String[] args) {
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
	
	private void reset() {
		arguments = null;
		functionStore = null;
		scopeStore = null;
	}
	
	private Function getGlobalFunction(Function func) {
		AtomicExpressionFunctionCall functionCall = new AtomicExpressionFunctionCall(func, null, arguments, -1, -1);
		Expression expr = new Expression(new AtomicExpressionFunctionCall[]{ functionCall }, -1, -1);
		Function $ = new Function(GLOBAL_FUNCTION_ID, GLOBAL_FUNCTION_ID, -1, -1);
		$.setExpression(expr);
		functionStore.put($.getUniqueID(), $);
		return $;
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

	private Representation constructRepresentation(ProgramContext pc) 
			throws CannotImportFunctionException {
		
		Scope globalScope = new Scope(null);
		scopeStore.put(GLOBAL_FUNCTION_ID, globalScope);
		
		Function mainFunction = constructFunction(pc.function(), GLOBAL_FUNCTION_ID);
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
				FileReader fileReader = new FileReader(filename);
				importedContext = AntlrManager.getProgramContext(AntlrManager.getLexer(fileReader));
			} catch (IOException e) {
				// TODO
				throw new CannotImportFunctionException(filename);
			}
			Function importedFunction = constructFunction(importedContext.function(), GLOBAL_FUNCTION_ID);
			globalScope.addFunction(importedFunction);
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


	private Function constructFunction(FunctionContext functionContext, String parentId) {
		
		FunctionBodyContext fbc = functionContext.functionBody();
		Function[] nestedFunctions = new Function[fbc.function().size()];
		
		String functionName = functionContext.Identifier().getText();
		String id = parentId + "." + functionName;
		
		Scope parentScope = scopeStore.get(parentId);
		Scope thisScope = new Scope(parentScope);
		scopeStore.put(id, thisScope);
		
		int line = functionContext.start.getLine();
		int col = functionContext.start.getCharPositionInLine();
		Function function = new Function(functionName, id, line, col);
		
		Expression expression = fbc.expression() != null ? constructExpression(fbc.expression(), function) : null;
		
		int numRules = fbc.rewriteRules() == null ? 0 : fbc.rewriteRules().rewriteRule().size();
		RewriteRule[] rules = new RewriteRule[numRules];
		for (int i = 0; i < rules.length; i++) {
			rules[i] = constructRewriteRule(fbc.rewriteRules().rewriteRule(i), function);
		}
		
		function.setExpression(expression);
		function.setRewriteRules(rules);
		functionStore.put(id, function);
		parentScope.addFunction(function);
		
		for (int i = 0; i < nestedFunctions.length; i++) {
			String nestedFunctionName = fbc.function(i).Identifier().getText();
			String uniqueId = id + "." + nestedFunctionName;
			nestedFunctions[i] = constructFunction(fbc.function(i), uniqueId);
			thisScope.addFunction(nestedFunctions[i]);
		}

		return function;
	}

	private RewriteRule constructRewriteRule(RewriteRuleContext sc, Function caller) {
		Expression expression = constructExpression(sc.expression(), caller);
		Signature[] signatures = new Signature[sc.signatures().signature().size()];
		for (int i = 0; i < signatures.length; i++) {
			SignatureContext psc = sc.signatures().signature(i);
			Pattern[] patterns = new Pattern[psc.pattern().size()];
			for (int j = 0; j < patterns.length; j++) {
				patterns[j] = constructPattern(psc.pattern(j), caller);
			}
			int line = psc.start.getLine();
			int col = psc.start.getCharPositionInLine();
			signatures[i] = new Signature(patterns, line, col);
		}
		int line = sc.start.getLine();
		int col = sc.start.getCharPositionInLine();
		return new RewriteRule(signatures, expression, line, col);
	}

	private Pattern constructPattern(PatternContext pc, Function caller) {
		AtomicPattern[] atomicPatterns = new AtomicPattern[pc.atomicPattern().size()];
		for (int i = 0; i < atomicPatterns.length; i++) {

			AtomicPatternContext apc = pc.atomicPattern(i);
			String identifier = null;
			Expression expr = null;
			
			if (apc.IdentifierEmpty() != null) {
				identifier = apc.IdentifierEmpty().getText();
			}
			else if (apc.Identifier() != null) {
				identifier = apc.Identifier().getText();
			}
			else if (apc.regexp() != null) {
								
				if (apc.regexp().atomicRegexp() != null) {
					String atomicRegexpString = null;
					if (apc.regexp().atomicRegexp().String() != null) {
						atomicRegexpString = apc.regexp().atomicRegexp().String().getText();
						atomicRegexpString = atomicRegexpString.substring(1, atomicRegexpString.length() - 1);
					}
					else if (apc.regexp().atomicRegexp().Number() != null) {
						atomicRegexpString = apc.regexp().atomicRegexp().Number().getText();
					}
					int line = apc.regexp().atomicRegexp().start.getLine();
					int col = apc.regexp().atomicRegexp().start.getCharPositionInLine();
					expr = new Expression(new AtomicExpressionLiteral(atomicRegexpString, line, col), line, col);
				}
				else {
					identifier = apc.regexp().Identifier() != null ? apc.regexp().Identifier().getText() : null;
					ExpressionContext ec = apc.regexp().expression();
					expr = ec == null ? null : constructExpression(ec, caller);
				}
			}
			int line = apc.start.getLine();
			int col = apc.start.getCharPositionInLine();
			atomicPatterns[i] = new AtomicPattern(identifier, expr, line, col);
		}
		int line = pc.start.getLine();
		int col = pc.start.getCharPositionInLine();
		return new Pattern(atomicPatterns, line, col);
	}

	private Expression constructExpression(ExpressionContext ec, Function caller) {
		int size = ec.atomicExpression().size();
		AtomicExpression[] atomicExpressions = new AtomicExpression[size];
		for (int i = 0; i < size; i++) {
			atomicExpressions[i] = constructAtomicExpression(ec.atomicExpression(i), caller);
		}
		int line = ec.start.getLine();
		int col = ec.start.getCharPositionInLine();
		return new Expression(atomicExpressions, line, col);
	}

	private AtomicExpression constructAtomicExpression(AtomicExpressionContext aec, Function caller) {
		int line = aec.start.getLine();
		int col = aec.start.getCharPositionInLine();
		if (aec.String() != null) {
			String string = aec.String().getText();
			string = string.substring(1, string.length() - 1);
			return new AtomicExpressionLiteral(string, line, col);
		}
		else if (aec.Number() != null) {
			return new AtomicExpressionLiteral(aec.Number().getText(), line, col);
		}
		else if (aec.Identifier() != null) {
			return new AtomicExpressionIdentifier(aec.Identifier().getText(), line, col);
		}
		else if (aec.functionCall() != null) {
			ArgumentsContext argsContext = aec.functionCall().arguments();
			int numArgs = argsContext == null ? 0 : argsContext.argument().size();
			Argument[] args = new Argument[numArgs];
			for (int i = 0; i < args.length; i++) {
				args[i] = new Argument(constructExpression(argsContext.argument(i).expression(), caller));
			}
			String calleeName = aec.functionCall().Identifier().getText();
			Function callee = scopeStore.get(caller.getUniqueID()).getFunction(calleeName);
			return new AtomicExpressionFunctionCall(caller, callee, args, line, col);
		}
		return null;
	}

}
