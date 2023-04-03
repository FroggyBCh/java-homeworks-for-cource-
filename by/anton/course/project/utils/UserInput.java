package by.anton.course.project.utils;


import by.anton.course.project.exceptions.MissingCarsException;

import java.util.Scanner;

public class UserInput  {
    public int getNumber(Scanner scanner, int max_size) {
        while (true) {
            if (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();

                    if (number <= max_size && number > 0) {
                        return number;
                    } else {
                        System.out.println("Введено неверное число!");
                    }
                }
            }
        }
    }

    public int getInt(Scanner scanner) {
        while (true) {
            if (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    return scanner.nextInt();
                }
            }
        }
    }

    public String getString(Scanner scanner) {
        while (true) {
            if (scanner.hasNext()) {
                return scanner.next();
            }
        }
    }
}
