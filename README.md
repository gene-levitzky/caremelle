# caremelle

Presenting an implementation of Aremelle, a simple, stripped down, purely functional programming language. 

Aremelle's basic unit of execution is the function. A function consists of zero or more recursively nested functions, zero or more statements, each of which maps a set of parameters to some output, and, if no statement is given, a single expression which is evaluated upon the invocation of the (constant or 0-ary) function.

The simplest Hello World program looks like:

    define helloWorld:
      out('Hello, World!').

In this example the function helloWorld consists of a single expression that invokes the native function `out`, which prints to the standard output.

