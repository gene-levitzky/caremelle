# caremelle

Presenting caremelle: an implementation of Aremelle, a simple, stripped down, purely functional programming language. 

Aremelle's basic unit of execution is the function. A function consists of zero or more recursively nested functions, zero or more rewrite rules called statements, each of which maps a set of parameters to some output, or, if no statement is given, a single expression which is evaluated upon the invocation of the (constant or 0-ary) function.

## Quick Preview

### Basic Syntax

The simplest Hello World program looks like:

    define helloWorld:
      out('Hello, World!').

In this example the function helloWorld consists of a single expression that invokes the native function `out`, which prints to the standard output.

The most powerful and most interesting aspect of Aremelle is its ability to match a function's argument to a pattern specified in the function's parameters. For example, say we want to split a string by a comma and return everything to the left of it. We may write something like this:

    define split:
      left ',' right = left.
 
Note that neither left nor right may be empty, or a NoMatchingSignatureException will be thrown. Equivalently, we could have written:

    define split:
      {'.+?'}:left ',' {'.+?'}:right = left.

If we want to allow left or right to be empty, then we can write:

    define split:
      left ',' right | {''}:left ',' right | left ',' {''}:right = left.

If the argument passed to split matches any of the patterns separated by a vertical bar, then the left hand side of the rule will be evaluated and returned. Note that there are many ways of accomplishing the same result. In all cases the function would be used as follows:

    split('this is the left side, and this is the right side')
    
Which would evaluate to `'this is the left side'`.

### Data types and operations

Aremelle has a single primitive data type: the string; and the only defined operation is concatenation, denoted simply by a space. The regular expression pattern matching described in the previous subsection can be seen as a pseudo-operation. The pattern matching abilities are exactly as powerful as that in Java's pattern matching API, and uses the exact same notation.

Not currently supported by caremelle, but Aremelle functions can also accept other functions as arguments, either by passing the function Identifier directly, or passing in the name of the function as a string. This works so long as the argument is treated like a function call. For example:

    define myFunction:
      define evaluateFunction:
        f, arg = f(arg).
      evaluateFunction(out, 'some output').

Equivalently:

    define myFunction:
      define evaluateFunction:
        f, arg = f(arg).
      evaluateFunction('out', 'some output').
      
Running either of the above functions will print "some output" to standard out. Note that 'out'('some output') is syntactically wrong, though this may change in the future.

### More complicated example

Here's a function that can be used to determine whether a given string is a palindrome:

    define palindrome:
	  '.' | '' | {'.'}:a {'.'}:a = 'true';
	  {'.'}:a {'.'}:b = 'false';
	  {'.'}:a middle {'.'}:a = palindrome(middle).
	  
Here we have multiple re-write rules or statements. Each one is terminated with a semicolon except for the last one which is terminated by a period. A statement consists of two parts: the left hand side (LHS) and the right hand side (RHS). The LHS consists of a list of signatures separated by a vertical bar, and each signature contains one or more patterns separated by a comma (in the above example, each signature contains only one pattern), and finally each pattern consists of one or more parameters separated by whitespace. In the above example, the first statement specifies `'.'`, `''`, and `{'.'}:a {'.'}:a` as its list of signatures. This means that if the given argument matches any of these patterns, then we evaluate and return the RHS of the statement, `'true'`. Note that the order of statements is important. The first statement to have a matching signature that matches the given argument will be the one whose RHS is evaluated. 

This example also illustrates the notion of back-referencing parameters. The third signature of the first statement and the sole signature of the third statement contain parameters that share the same name, `a`. This means that the value "captured" by the first `a` must match identically with the value "captured" by the second `a` for the argument to match the overall pattern.
