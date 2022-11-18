//**********************************************************************
//  TooManyIntegersException.java                 Author: Brian Salchert
//
//  Extends the Exception class to provide an exception for instances
//  with too many integers to properly evaluate an expression in
//  PostfixExpression.java.
//**********************************************************************

public class TooManyIntegersException extends Exception {
    //------------------------------------------------------------------
    //  Prepares the error message for the exception.
    //------------------------------------------------------------------
    TooManyIntegersException (String message) {
        super(message);
    }
}
