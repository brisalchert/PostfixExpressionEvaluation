import java.util.Stack;

//**********************************************************************
//  PostfixExpression.java                        Author: Brian Salchert
//
//  Provides methods for evaluating an expression with postfix
//  operators using the Stack class.
//**********************************************************************

public class PostfixExpression {
    private Stack<Integer> operands = new Stack<Integer>();

    public static int evaluate(String expression) throws TooManyIntegersException {
        String[] elements = expression.split(" ");
        int count;    // Ensures no more than 2 ints are entered before an operator

        TooManyIntegersException problem =
            new TooManyIntegersException("Too many integers in expression.");

        for (String element : elements) {

        }
    }
}
