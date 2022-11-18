import java.util.Stack;

//**********************************************************************
//  PostfixExpression.java                        Author: Brian Salchert
//
//  Provides methods for evaluating an expression using postfix
//  operators using the Stack class.
//**********************************************************************

public class PostfixExpression {
    private Stack<Integer> operands;

    //------------------------------------------------------------------
    //  Constructor: Initializes the stack used to evaluate the
    //  expression.
    //------------------------------------------------------------------
    public PostfixExpression() {
        operands = new Stack<Integer>();
    }
}
