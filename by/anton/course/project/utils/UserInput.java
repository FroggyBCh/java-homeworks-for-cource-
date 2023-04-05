/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.course.project.utils;


import java.util.Scanner;

/**
 *
 * The class needed to handle user input
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */

public class UserInput  {

    /* a method to get a number from the user for a specific selection */
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

    /* the method needed to get just a number from the user */
    public int getInt(Scanner scanner) {
        while (true) {
            if (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    return scanner.nextInt();
                }
            }
        }
    }

    /* the method needed to get a string from the user */
    public String getString(Scanner scanner) {

        /*P.S. I guess I was too sleepy when I wrote this. */
        while (true) {
            if (scanner.hasNext()) {
                return scanner.next();
            }
        }
    }
}
