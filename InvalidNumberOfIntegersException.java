//**********************************************************************
//  InvalidNumberofIntegersException.java         Author: Brian Salchert
//
//  Extends the Exception class to provide an exception for instances
//  with an invalid number of integers to properly evaluate an
//  expression in PostfixExpression.java.
//**********************************************************************

public class InvalidNumberOfIntegersException extends Exception {
    //------------------------------------------------------------------
    //  Prepares the error message for the exception.
    //------------------------------------------------------------------
    InvalidNumberOfIntegersException (String message) {
        super(message);
    }
}
