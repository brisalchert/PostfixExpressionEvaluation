//**********************************************************************
//  TooManyIntegersException.java                 Author: Brian Salchert
//
//  Extends the Exception class to provide an exception for instances
//  with too many integers to properly evaluate an expression in
//  PostfixExpression.java.
//**********************************************************************

public class InvalidNumberOfIntegersException extends Exception {
    //------------------------------------------------------------------
    //  Prepares the error message for the exception.
    //------------------------------------------------------------------
    InvalidNumberOfIntegersException (String message) {
        super(message);
    }
}
