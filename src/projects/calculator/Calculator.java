package calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numberOfCalculations = 0;
        String horizontalLine = "--------------------------------------------";


        System.out.println("");
        System.out.println("Hello, welcome to my calculator :D ");
        System.out.println("Lets get started! ");
        System.out.println("");

        boolean likeToExit = false;

        while (!likeToExit) {

            System.out.println("Enter your first number: ");
            double number1 = input.nextDouble();

            System.out.println("Enter your operator: ");
            String operator = input.next();

            // /*
            while (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")) {
                System.out.println("The entered operator is invalid or not available. Please try again ");
                System.out.println("Enter your operator: ");
                operator = input.next();
            }
            // */

            System.out.println("Enter your second number: ");
            double number2 = input.nextDouble();

            calculate(number1, number2, operator, horizontalLine);

            System.out.println("");
            System.out.println("Would you like to make another calculation? ");
            System.out.println("Type 'y' for yes or 'n' for no: ");
            String answer = input.next();

            if (answer.equals("y")) {
                System.out.println("");
                System.out.println("Here we go again! ");
                System.out.println("");
                System.out.println(horizontalLine);
                System.out.println("");
            } else {
                if (answer.equals("n")) {
                    System.out.println("");
                    System.out.println(horizontalLine);
                    System.out.println("");
                    System.out.println("Okay, see you next time ");
                    likeToExit = true;
                } else {
                    System.out.println("Wrong input, please try again ");
                }
            }
            numberOfCalculations++;
        }
        System.out.println("");
        if (numberOfCalculations <= 1) {
            System.out.println("You made one calculation ;) ");
        } else {
            System.out.printf("You made %d calculations ;) %n", numberOfCalculations);
        }
    }

    static void calculate (double n1, double n2, String op, String horizontalLine) {

        System.out.println("");
        System.out.println(horizontalLine);
        System.out.println("");
        System.out.println("Number 1: " + n1);
        System.out.println("Number 2: " + n2);
        System.out.println("Operator: " + op);
        System.out.println("");

        switch (op) {
            case "+" -> {
                System.out.printf("Your calculation is: %f %s %f %nYour result is: %f%n ", n1, op, n2, (n1 + n2));
            }
            case "-" -> {
                System.out.printf("Your calculation is: %f %s %f %nYour result is: %f%n ", n1, op, n2, (n1 - n2));
            }
            case "*" -> {
                System.out.printf("Your calculation is: %f %s %f %nYour result is: %f%n ", n1, op, n2, (n1 * n2));
            }
            case "/" -> {
                System.out.printf("Your calculation is: %f %s %f %n", n1, op, n2);
                if (n2 == 0) {
                    System.out.println("Error during calculation, divided by zero. Try it again with another number ");
                } else {
                    System.out.printf("Your result is: %f %n ", (n1 / n2));
                }
            }
            default -> System.out.println("An error occurred during the calculation. Please try again :( ");
        }
    }
}
