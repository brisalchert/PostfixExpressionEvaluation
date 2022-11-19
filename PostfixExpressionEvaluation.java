//**********************************************************************
//  PostfixExpressionEvaluation.java             Author: Brian Salchert
//
//  Driver class for PostfixExpression.java. Allows the user to enter
//  a postfix-operator expression which it then evaluates.
//**********************************************************************

import java.util.Scanner;

public class PostfixExpressionEvaluation {
    public static void main(String[] args) throws InvalidExpressionException {
        Scanner input = new Scanner(System.in);
        String userInput;
        int calculationResult;
        PostfixExpression expression = new PostfixExpression();

        System.out.println();
        System.out.print("\tEnter a postfix-operator expression: ");
        userInput = input.nextLine();

        calculationResult = expression.evaluate(userInput);

        System.out.println();
        System.out.print("\tEvaluated expression result: ");
        System.out.print(calculationResult);
        System.out.println();
        System.out.println();

        input.close();
    }
}
