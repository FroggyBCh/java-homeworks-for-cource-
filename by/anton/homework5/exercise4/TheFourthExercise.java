package by.anton.homework5.exercise4;

import java.util.Scanner;

public class TheFourthExercise {
    private double theFirstDigit;
    private double theSecondDigit;
    private double calculationAnswer;
    public void calculator(Scanner scanner) {
        System.out.println("Запущено задание 4\nВведите число или \"stop\"");

        while (true) {
            System.out.println("Введите число №1");
            if(scanner.hasNextLine()) {
                if (scanner.hasNextDouble()) {
                    theFirstDigit = scanner.nextDouble();
                } else if (scanner.nextLine().equals("stop")) {
                    break;
                } else {
                    System.out.println("Введите число или \"stop\"");
                }
            }

            System.out.println("Введите число №2");
            if(scanner.hasNextLine()) {
                if (scanner.hasNextDouble()) {
                    theSecondDigit = scanner.nextDouble();
                } else if (scanner.nextLine().equals("stop")) {
                    break;
                } else {
                    System.out.println("Введите число или \"stop\"");
                }
            }

            System.out.println("Введите знак операции +, -, /, *");
            if (scanner.hasNextLine()) {
                if (scanner.nextLine().equals("+")) {
                    calculationAnswer = theFirstDigit + theSecondDigit;
                    System.out.println(theFirstDigit + "+" + theSecondDigit + "=" + calculationAnswer);
                } else if (scanner.nextLine().equals("-")) {
                    calculationAnswer = theFirstDigit - theSecondDigit;
                    System.out.println(theFirstDigit + "-" + theSecondDigit + "=" + calculationAnswer);
                } else if (scanner.nextLine().equals("/")) {
                    calculationAnswer = theFirstDigit / theSecondDigit;
                    System.out.println(theFirstDigit + "/" + theSecondDigit + "=" + calculationAnswer);
                } else if (scanner.nextLine().equals("*")) {
                    calculationAnswer = theFirstDigit * theSecondDigit;
                    System.out.println(theFirstDigit + "*" + theSecondDigit + "=" + calculationAnswer);
                } else if (scanner.nextLine().equals("stop")) {
                    break;
                } else {
                    System.out.println("Введите нужный знак");
                }
            }
        }
    }
}
