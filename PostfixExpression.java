//**********************************************************************
//  PostfixExpression.java                        Author: Brian Salchert
//
//  Provides methods for evaluating an expression with postfix
//  operators using the Stack class.
//**********************************************************************

import java.util.EmptyStackException;
import java.util.Stack;

public class PostfixExpression {
    private Stack<Integer> operands;

    //------------------------------------------------------------------
    //  Constructor: sets up a PostfixEpression object with its own
    //  Stack for operands.
    //------------------------------------------------------------------
    public PostfixExpression() {
        operands = new Stack<Integer>();
    }

    //------------------------------------------------------------------
    //  Evaluates the postfix expression and throws an exception if
    //  there are too many or too few integers in the expression.
    //------------------------------------------------------------------
    public int evaluate(String expression) throws InvalidNumberOfIntegersException {
        String[] elements = expression.split(" ");
        int count = 0;    // Ensures no more than 2 ints are entered before an operator
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

    //------------------------------------------------------------------
    //  Adds the top two elements of the Stack and places the result
    //  in the stack.
    //------------------------------------------------------------------
    private void add() {
        int result;
        int operand1 = operands.pop();
        int operand2 = operands.pop();

        result = (operand1 + operand2);
        operands.push(result);
    }

    //------------------------------------------------------------------
    //  Subtracts the top two elements of the Stack and places the
    //  result in the stack.
    //------------------------------------------------------------------
    private void subtract() {
        int result;
        int operand1 = operands.pop();
        int operand2 = operands.pop();

        result = (operand1 - operand2);
        operands.push(result);
    }

    //------------------------------------------------------------------
    //  Multiplies the top two elements of the Stack and places the
    //  result in the stack.
    //------------------------------------------------------------------
    private void multiply() {
        int result;
        int operand1 = operands.pop();
        int operand2 = operands.pop();

        result = (operand1 * operand2);
        operands.push(result);
    }

    //------------------------------------------------------------------
    //  Divides the top two elements of the Stack and places the result
    //  in the stack.
    //------------------------------------------------------------------
    private void divide() {
        int result;
        int operand1 = operands.pop();
        int operand2 = operands.pop();

        result = (operand1 / operand2);
        operands.push(result);
    }

    //------------------------------------------------------------------
    //  Divides the top two elements of the Stack and places the
    //  remainder in the stack.
    //------------------------------------------------------------------
    private void modulo() {
        int result;
        int operand1 = operands.pop();
        int operand2 = operands.pop();

        result = (operand1 % operand2);
        operands.push(result);
    }
}
