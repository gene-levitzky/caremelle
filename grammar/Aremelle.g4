grammar Aremelle;

program
    :   function?
    ;
  
function
    :   DEFINE Identifier COLON functionBody DOT
    ;
    
functionBody
    :   function* ( expression | rewriteRules )
    ;
    
rewriteRules
    :   rewriteRule (SEMICOLON rewriteRule)*
    ;

rewriteRule
    :   signatures EQUAL expression
    ;
    
expression
    :   atomicExpression+
    ;
    
atomicExpression
    :   functionCall 
    |   String 
    |   Number 
    |   Identifier
    ;
    
functionCall
    :   Identifier LEFT_PAREN arguments? RIGHT_PAREN
    ;
    
arguments
    :   argument (COMMA argument)*
    ;
    
argument
    :   expression
    ;
    
signatures
    :   signature (BAR signature)*
    ;
    
signature
    :   pattern (COMMA pattern)*
    ;
    
pattern
    :   parameter+
    ;
    
parameter
    :   IdentifierParameter | Identifier | regexp
    ;
    
regexp
    :   atomicRegexp
    |   LEFT_BRACE atomicRegexp RIGHT_BRACE (COLON Identifier)?
    ;
    
atomicRegexp
    :   String | Number
    ;
    
/*------------------------------------------------------------------
 *                             LEXER RULES
 *------------------------------------------------------------------*/

BAR
    :   '|'
    ;
    
CARET
    :   '^'
    ;

COMMA
    :   ','
    ;
    
COLON
    :   ':'
    ;

DEFINE
    :   'define'
    ;
    
fragment DIGIT
    :   '0'..'9'
    ;
    
DOLLAR
		:		'$'
		;
		
DOT
    :   '.'
    ;
    
EQUAL
    :   '='
    ;
    
fragment LETTER
    :   ('a'..'z' | 'A'..'Z')
    ;
    
LEFT_BRACE
    :   '{'
    ;
    
LEFT_PAREN
    :   '('
    ;
    
RIGHT_BRACE
    :   '}'
    ;
    
RIGHT_PAREN
    :   ')'
    ;
    
SEMICOLON
    :   ';'
    ;
    
SLASH
    :   '/'
    ;
    
SPACE
    :    (' ' | '\t' | '\r' | '\n' | '\u000C')+ -> channel(HIDDEN)
    ;
    
fragment Complex
    :   Real '+' Real 'i'
    ;
    
fragment IdentifierFragment
    :   LETTER (LETTER | DIGIT)*
    ;
		
Identifier
		:		IdentifierFragment
		;
		
IdentifierParameter
		:		DOLLAR IdentifierFragment
		;
    
fragment Integer
    :   '-'? Natural
    ;
    
fragment Natural
    :   DIGIT+
    ;
    
Number
    :   Natural | Integer | Rational | Real | Complex
    |   '(' Number ')'
    ;
    
fragment Rational
    :   Integer SLASH Natural
    ;
    
fragment Real
    :   Integer (DOT Integer)?
    ;
    
RegexpOperatorBinary
    :   BAR
    ;
    
RegexpOperatorExponent
    :   CARET
    ;
    
RegexpOperatorUnary
    :   '*' | '+' | '?'
    ;
    
String
    :   '\'' StringText '\''
    ;
    
fragment StringText
    :   .*?
    ;