package by.anton.homework5.exercise2;

import java.util.Scanner;

public class TheSecondExercise {
    private int count = 0;
    private int allNumbers = 0;

    public void calculationAverageValueOfNumbers(Scanner scanner) {
        System.out.println("Запущено задание 2\nВводите числа либо \"stop\"");
        while (true) {
            if (scanner.hasNextLine()) {
                if (scanner.hasNextInt()) {
                    allNumbers += scanner.nextInt();
                    count += 1;
                } else if (scanner.nextLine().equals("stop")) {
                    System.out.println("Среднее арифметическое чисел >> " + allNumbers / count);
                    break;
                } else if (!scanner.hasNextInt() && !scanner.nextLine().equals("stop")) {
                    System.out.println("Введите число либо \"stop\"");
                }

            }
        }
    }
}
