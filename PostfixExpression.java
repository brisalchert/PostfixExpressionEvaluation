//**********************************************************************
//  PostfixExpression.java                        Author: Brian Salchert
//
//  Provides methods for evaluating an expression with postfix
//  operators using the Stack class.
//**********************************************************************

import java.util.EmptyStackException;
import java.util.Stack;

public class PostfixExpression {
    //------------------------------------------------------------------
    //  Evaluates the postfix expression and throws an exception if
    //  there are too many or too few integers in the expression.
    //------------------------------------------------------------------
    public static int evaluate(String expression) throws InvalidNumberOfIntegersException {
        Stack<Integer> operands = new Stack<Integer>();
        String[] elements = expression.split(" ");
        int count;    // Ensures no more than 2 ints are entered before an operator
        int result;

        InvalidNumberOfIntegersException problem =
            new InvalidNumberOfIntegersException("Invalid number of integers in expression.");

        for (String element : elements) {
            int nextNumber;

            try {
                nextNumber = Integer.parseInt(element);

                operands.push(nextNumber);
                count++;

                if (count > 2) {
                    throw problem;
                }
            }
            catch (NumberFormatException exception) {
                try {
                    switch (element) {
                        case "+":
                            add();
                            break;
                        case "-":
                            subtract();
                            break;
                        case "*":
                            multiply();
                            break;
                        case "/":
                            divide();
                            break;
                        case "%":
                            modulo();
                            break;
                        default:
                            System.out.println("Invalid operator in expression.");
                    }
                }
                catch (EmptyStackException exception2) {
                    throw problem;
                }

                count = 0;
            }
        }

        result = operands.pop();

        if (!operands.empty()) {
            throw problem;
        }

        return result;

    }
}
