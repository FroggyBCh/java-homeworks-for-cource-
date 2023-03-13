package by.anton.homework5.exercise3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TheThirdExercise {
    private List<Integer> listOfNumbers = new ArrayList<Integer>();
    public void enteringAndSortingList(Scanner scanner) {
        System.out.println("Запущено задание 3\nВводите числа, либо \"stop\", либо \"status\"");

        while (true) {
            if (scanner.hasNextLine()) {
                if (scanner.hasNextInt()) {
                    listOfNumbers.add(scanner.nextInt());
                } else if (scanner.nextLine().equals("stop")) {
                    break;
                } else if (scanner.nextLine().equals("status")) {
                    Collections.sort(listOfNumbers);
                    System.out.println("Сортированный список >> \n" + listOfNumbers);
                } else if (!scanner.hasNextInt() && !scanner.nextLine().equals("stop") && !scanner.nextLine().equals("status")) {
                    System.out.println("Введите число, либо \"stop\", либо \"status\"");
                }

            }
        }
    }
}
