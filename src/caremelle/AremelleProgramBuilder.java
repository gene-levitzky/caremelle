package caremelle;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import exceptions.CannotImportFunctionException;
import antlr.AremelleLexer;
import antlr.AremelleParser;
import antlr.AremelleParser.ArgumentsContext;
import antlr.AremelleParser.AtomicExpressionContext;
import antlr.AremelleParser.ExpressionContext;
import antlr.AremelleParser.FunctionBodyContext;
import antlr.AremelleParser.FunctionContext;
import antlr.AremelleParser.ImportStatementContext;
import antlr.AremelleParser.ParameterContext;
import antlr.AremelleParser.PatternContext;
import antlr.AremelleParser.ProgramContext;
import antlr.AremelleParser.RewriteRuleContext;
import antlr.AremelleParser.SignatureContext;
import aremelle.AtomicExpression;
import aremelle.AtomicExpressionFunctionCall;
import aremelle.AtomicExpressionIdentifier;
import aremelle.AtomicExpressionLiteral;
import aremelle.Parameter;
import aremelle.Expression;
import aremelle.Function;
import aremelle.Pattern;
import aremelle.Signature;
import aremelle.Program;
import aremelle.RewriteRule;

public class AremelleProgramBuilder {
	
	public AremelleProgramBuilder(){}
	
	public Program build(FileReader fileReader, String[] args) 
			throws CannotImportFunctionException, IOException {
		return parse(getLexer(fileReader), args);
	}
	
	public Program build(String code, String[] args) 
			throws CannotImportFunctionException, IOException {
		return parse(getLexer(code), args);
	}
	
	private Program parse(AremelleLexer lexer, String[] args)
			throws CannotImportFunctionException {
        return constructProgram(getProgramContext(lexer), args);
	}
	
	private ProgramContext getProgramContext(AremelleLexer lexer) {
		CommonTokenStream tokens = new CommonTokenStream(lexer);
        AremelleParser parser = new AremelleParser(tokens);
        return parser.program();
	}
	
	private AremelleLexer getLexer(FileReader reader) throws IOException {
		return new AremelleLexer(new ANTLRInputStream(reader));
	}
	
	private AremelleLexer getLexer(String code) throws IOException {
		return new AremelleLexer(new ANTLRInputStream(code));
	}
	
	public Program constructProgram(ProgramContext programContext, String[] args) 
			throws CannotImportFunctionException {
		
		List<Function> importedFunctions = new ArrayList<Function>();
		for (int i = 0; i < programContext.importStatement().size(); i++) {
			ImportStatementContext isc = programContext.importStatement(i);
			String filename = isc.String().getText();
			filename = filename.substring(1, isc.String().getText().length() - 1);
			try {
				if (filename.endsWith(".rml")) {
					AremelleLexer lexer = getLexer(new FileReader(filename));
					ProgramContext importedProgram = getProgramContext(lexer);
					Function importedFunction = constructFunction(importedProgram.function());
					importedFunctions.add(importedFunction);
				}
				else {
					File[] files = new File(filename).listFiles();
					if (files != null) {
						for (File f : files) {
							AremelleLexer lexer = getLexer(new FileReader(f));
							ProgramContext importedProgram = getProgramContext(lexer);
							Function importedFunction = constructFunction(importedProgram.function());
							importedFunctions.add(importedFunction);
						}
					}
				}
			}
			catch(NullPointerException | IOException e1) {
				throw new CannotImportFunctionException(filename);
			}
		}
		Function[] importedFunctionsArray = new Function[importedFunctions.size()];
		for (int i = 0; i < importedFunctionsArray.length; i++) {
			importedFunctionsArray[i] = importedFunctions.get(i);
		}
    	return new Program(constructFunction(programContext.function()), importedFunctionsArray, args);
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
    	return new Function(functionContext.Identifier().getText(), nestedFunctions, expression, rules);
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
    		String name = apc.IdentifierParameter() == null ? 
    				null : apc.IdentifierParameter().getText();
    		name = name != null ? name :
    				apc.Identifier() != null ? apc.Identifier().getText() : null; 
    		String regexp = null;
    		if (apc.regexp() != null) {
	    		regexp = apc.regexp().atomicRegexp().getText();
	    		// Strip quotes
	    		if (regexp != null) {
	    			try {
	    				regexp = String.valueOf(Integer.parseInt(regexp));
	    			}
	    			catch (NumberFormatException npe) {
	    				try {
	    					regexp = String.valueOf(Double.parseDouble(regexp));
	    				}
	    				catch (NumberFormatException npe2) {
	    					regexp = regexp.substring(1, regexp.length() - 1);
	    				}
	    			}
	    		}
	    		name = apc.regexp().Identifier() == null ? 
	    				name : apc.regexp().Identifier().getText();
    		}
    		parameters[i] = new Parameter(name, regexp);
    	}
    	return new Pattern(parameters);
    }

	private Expression constructExpression(ExpressionContext expressionContext) {
    	AtomicExpression[] atomicExpressions = new AtomicExpression[expressionContext.atomicExpression().size()];
    	for (int i = 0; i < atomicExpressions.length; i++) {
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
