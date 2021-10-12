package com.pb.antonov.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int operand1, operand2;
        double result;
        String sign;

        System.out.print("Enter first number: ");
        operand1 = scan.nextInt();
        System.out.print("Enter second number: ");
        operand2 = scan.nextInt();
        System.out.print("Enter operation sign: ");
        sign = scan.next();

        switch (sign) {
            case "+":
                result = operand1 + operand2;
                System.out.println(operand1 + " " + sign + " " + operand2 + " = " + String.format("%,.0f", result));
                break;
            case "-":
                result = operand1 - operand2;
                System.out.println(operand1 + " " + sign + " " + operand2 + " = " + String.format("%,.0f", result));
                break;
            case "*":
                result = operand1 * operand2;
                System.out.println(operand1 + " " + sign + " " + operand2 + " = " + String.format("%,.0f", result));
                break;
            case "/":
                if(operand2==0){
                    System.out.println("You can't divide by zero!");
                }
                else {
                    result = (double) operand1 / operand2;
                    System.out.println(operand1 + " " + sign + " " + operand2 + " = " + result);
                }
                break;
            default:
                System.out.println("Unknown operator!");
        }

    }
}
