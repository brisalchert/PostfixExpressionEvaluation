//**********************************************************************
//  InvalidExpressionException.java         Author: Brian Salchert
//
//  Extends the Exception class to provide an exception for instances
//  with an invalid expression in PostfixExpression.java.
//**********************************************************************

public class InvalidExpressionException extends Exception {
    //------------------------------------------------------------------
    //  Prepares the error message for the exception.
    //------------------------------------------------------------------
    InvalidExpressionException (String message) {
        super(message);
    }
}
