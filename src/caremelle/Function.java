package caremelle;

import exceptions.NoMatchingSignatureException;
import exceptions.NotANumberException;
import exceptions.UndefinedVariableException;

public class Function extends NamedEntity {

	private final Expression expression;
	private final Statement[] statements;
	private final Scope scope;

	public Function(String name, Function[] functions, Expression expression, Statement[] statements) {
		super(name);
		
		scope = new Scope();

		if (functions != null) {
			for (Function function : functions) {
				scope.addFunction(function);
				function.setParentScope(scope);
			}
		}

		this.expression = expression;
		this.statements = statements;
	}
	
	public void setParentScope(Scope parent) {
		scope.setOuterScope(parent);
	}

	public Expression getExpression() {
		return expression;
	}

	private String evaluate(Argument[] args, Scope scope) 
			throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {


		// If the function body has expression(s), then it's a 0-ary function;
		// simply evaluate the expression(s) and return the result
		if (expression != null) {
			return expression.evaluate(scope);
		}

		// Otherwise, we need to find a statement with a matching signature
		// and return its evaluated expression(s)		
		Parameters matchingParameters = null;
		for (Statement statement : statements) {			
			if ((matchingParameters = statement.getMatchingParameters(args, scope)) != null) {
				scope.addParameters(matchingParameters);
				return statement.evaluate(scope);
			}
		}

		throw null;//new NoMatchingSignatureException(getName(), args);
	}
	
	public Scope getScope() {
		return scope;
	}

	public Statement getStatementWithMatchingParameters(Argument[] args) throws NotANumberException {
		// Otherwise, we need to find a statement with a matching signature
		// and return its evaluated expression(s)		
		Parameters matchingParameters = null;
		for (Statement statement : statements) {			
			if ((matchingParameters = statement.getMatchingParameters(args, scope)) != null) {
				scope.addParameters(matchingParameters);
				return statement;
			}
		}

		return null;
	}
	
	public String evaluate(Argument[] args) 
			throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		return evaluate(args, this.scope);		
	}

	/*
	 * ********************************************
	 */

	/*
	 *  BUILT IN FUNCTIONS
	 */

	/*
	 * ********************************************
	 */

	public static final Function INC = new Function("inc", null, null, null) {
		
		@Override
		public Statement getStatementWithMatchingParameters(Argument[] args) throws NotANumberException {
			String result = null;
			if (args.length == 1) {
				try {
					result = String.valueOf(Integer.parseInt(args[0].toString()) + 1);
				}
				catch (NumberFormatException nfe) {
					try {
						result = String.valueOf(Double.parseDouble(args[0].toString()) + 1);
					}
					catch (NumberFormatException nfe2) {
						throw new NotANumberException(args[0].toString());
					}
				}	
			}
			Parameters params = new Parameters(new Parameter(new AtomicParameter("num")));
			Expression expression = new Expression(new AtomicExpressionLiteral(result));
			return new Statement(new Parameters[]{params}, expression);
		}

		@Override
		public String evaluate(Argument[] args) 
				throws NoMatchingSignatureException, UndefinedVariableException, NotANumberException {
			if (args.length == 1) {
				try {
					return String.valueOf(Integer.parseInt(args[0].toString()) + 1);
				}
				catch (NumberFormatException nfe) {
					try {
						return String.valueOf(Double.parseDouble(args[0].toString()) + 1);
					}
					catch (NumberFormatException nfe2) {
						throw new NotANumberException(args[0].toString());
					}
				}	
			}
			throw new NoMatchingSignatureException(getName(), args);
		}
	};

	public static final Function DEC = new Function("dec", null, null, null) {
		
		@Override
		public Statement getStatementWithMatchingParameters(Argument[] args) throws NotANumberException {
			String result = null;
			if (args.length == 1) {
				try {
					result = String.valueOf(Integer.parseInt(args[0].toString()) - 1);
				}
				catch (NumberFormatException nfe) {
					try {
						result = String.valueOf(Double.parseDouble(args[0].toString()) - 1);
					}
					catch (NumberFormatException nfe2) {
						throw new NotANumberException(args[0].toString());
					}
				}	
			}
			Parameters params = new Parameters(new Parameter(new AtomicParameter("num")));
			Expression expression = new Expression(new AtomicExpressionLiteral(result));
			return new Statement(new Parameters[]{params}, expression);
		}

		@Override
		public String evaluate(Argument[] args) 
				throws NoMatchingSignatureException, UndefinedVariableException, NotANumberException {
			if (args.length == 1) {
				try {
					return String.valueOf(Integer.parseInt(args[0].toString()) - 1);
				}
				catch (NumberFormatException nfe) {
					try {
						return String.valueOf(Double.parseDouble(args[0].toString()) - 1);
					}
					catch (NumberFormatException nfe2) {
						throw new NotANumberException(args[0].toString());
					}
				}	
			}
			throw new NoMatchingSignatureException(getName(), args);
		}
	};

	public static final Function OUT = new Function("out", null, null, null) {
		
		@Override
		public Statement getStatementWithMatchingParameters(Argument[] args) throws NotANumberException {
			if (args.length != 0 && args.length != 1) {
				return null;
			}
			Parameters params = new Parameters(new Parameter(new AtomicParameter("output")));
			Expression expression = new Expression(new AtomicExpressionLiteral(""){
				@Override
				public String getValue() {
					if (args.length == 1) {
						System.out.println(args[0]);
					}
					else {
						System.out.println();
					}
					return "";
				}
			});
			return new Statement(new Parameters[]{params}, expression);
		}

		@Override
		public String evaluate(Argument[] args) 
				throws NoMatchingSignatureException, UndefinedVariableException, NotANumberException {		
			if (args.length == 0 || args.length == 1) {
				if (args.length == 1) {
					System.out.println(args[0]);
				}
				else {
					System.out.println();
				}
				return "";
			}
			
			throw new NoMatchingSignatureException(getName(), args);
		}
	};

	public static final Function IN = new Function("in", null, null, null) {
		
		@Override
		public Statement getStatementWithMatchingParameters(Argument[] args) throws NotANumberException {
			if (args.length != 0) {
				return null;
			}
			Parameters params = new Parameters(new Parameter());
			Expression expression = new Expression(new AtomicExpressionLiteral(""){
				@Override
				public String getValue() {
					return Resources.getIn().nextLine();
				}
			});
			return new Statement(new Parameters[]{params}, expression);
		}

		@Override
		public String evaluate(Argument[] args) 
				throws NoMatchingSignatureException, UndefinedVariableException, NotANumberException {
			if (args.length == 0) {
				return Resources.getIn().nextLine();
			}
			
			throw new NoMatchingSignatureException(getName(), args);
		}
	};

	public static final Function RANDOM = new Function("random", null, null, null) {

		@Override
		public String evaluate(Argument[] args) 
				throws NoMatchingSignatureException, UndefinedVariableException, NotANumberException {
			if (args.length == 2) {
				int start, finish;
				try {
					start = Integer.parseInt(args[0].toString());
				}
				catch (NumberFormatException e) {
					throw new NotANumberException(args[0].toString());
				}
				try {
					finish = Integer.parseInt(args[1].toString());
				}
				catch (NumberFormatException e) {
					throw new NotANumberException(args[1].toString());
				}
				return String.valueOf((int) (Math.random() * finish + start));
			}
			
			throw new NoMatchingSignatureException(getName(), args);
		}
	};
	
	public static Function[] getNativeFunctions() {
		return new Function[] {
			INC, DEC, IN, OUT, RANDOM
		};
	}
}
