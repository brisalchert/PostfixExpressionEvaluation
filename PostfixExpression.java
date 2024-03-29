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
    private InvalidExpressionException problem;

    //------------------------------------------------------------------
    //  Constructor: sets up a PostfixEpression object with its own
    //  Stack for operands.
    //------------------------------------------------------------------
    public PostfixExpression() {
        operands = new Stack<Integer>();
    }

    //------------------------------------------------------------------
    //  Evaluates the postfix expression and throws an exception if
    //  the expression is invalid.
    //------------------------------------------------------------------
    public int evaluate(String expression) throws InvalidExpressionException {
        String[] elements = expression.split(" ");
        int count = 0;    // Ensures no more than 2 ints entered before an operator
        int result;

        for (String element : elements) {
            int nextNumber;

            try {
                nextNumber = Integer.parseInt(element);

                operands.push(nextNumber);
                count++;

                if (count > 2) {
                    tooManyInts();
                }
            }
            catch (NumberFormatException exception) {
                try {
                    doOperation(element);
                    count = 0;
                }
                catch (EmptyStackException exception2) {
                    tooFewInts();
                }
            }
        }

        result = operands.pop();

        if (!operands.empty()) {
            tooManyInts();
        }

        return result;

    }

    //------------------------------------------------------------------
    //  Sets up the exception for expressions with too many integers.
    //------------------------------------------------------------------
    private void tooManyInts() throws InvalidExpressionException {
        problem = new InvalidExpressionException("Too many integers.");

        throw problem;
    }

    //------------------------------------------------------------------
    //  Sets up the exception for expressions with too few integers.
    //------------------------------------------------------------------
    private void tooFewInts() throws InvalidExpressionException {
        problem = new InvalidExpressionException("Too few integers.");

        throw problem;
    }

    //------------------------------------------------------------------
    //  Determines which operation to execute based on input.
    //------------------------------------------------------------------
    private void doOperation(String operator) throws InvalidExpressionException {
        switch (operator) {
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
                problem = new InvalidExpressionException("Invalid operator.");

                throw problem;
        }
    }
    //------------------------------------------------------------------
    //  Adds the top two elements of the Stack and places the result
    //  on the stack.
    //------------------------------------------------------------------
    private void add() {
        int result;
        int operand2 = operands.pop();
        int operand1 = operands.pop();

        result = (operand1 + operand2);
        operands.push(result);
    }

    //------------------------------------------------------------------
    //  Subtracts the top element of the Stack from the next highest
    //  element and places the result on the stack.
    //------------------------------------------------------------------
    private void subtract() {
        int result;
        int operand2 = operands.pop();
        int operand1 = operands.pop();

        result = (operand1 - operand2);
        operands.push(result);
    }

    //------------------------------------------------------------------
    //  Multiplies the top two elements of the Stack and places the
    //  result on the stack.
    //------------------------------------------------------------------
    private void multiply() {
        int result;
        int operand2 = operands.pop();
        int operand1 = operands.pop();

        result = (operand1 * operand2);
        operands.push(result);
    }

    //------------------------------------------------------------------
    //  Divides the top element of the Stack into the next highest
    //  element and places the result on the stack.
    //------------------------------------------------------------------
    private void divide() {
        int result;
        int operand2 = operands.pop();
        int operand1 = operands.pop();

        result = (operand1 / operand2);
        operands.push(result);
    }

    //------------------------------------------------------------------
    //  Divides the top element of the Stack into the next highest
    //  element and places the remainder on the stack.
    //------------------------------------------------------------------
    private void modulo() {
        int result;
        int operand2 = operands.pop();
        int operand1 = operands.pop();

        result = (operand1 % operand2);
        operands.push(result);
    }
}
