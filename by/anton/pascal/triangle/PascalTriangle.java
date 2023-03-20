/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.pascal.triangle;

import java.util.Scanner;

/**
 * This class is used to input the number of lines
 * and output pascasl's triangle equal to the number of lines
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class PascalTriangle {
    private static final Scanner scanner = new Scanner(System.in);    //scanner is created to get number
                                                                      // of rows from the user
    private              int     arrayOfRows;                         //variable to set the size of the array

    /* This method is used to calculate the triangle and enter it into the array
    P.S. I decided to do everything together, if necessary, I will do it separately */
    public void triangleCalculation() {
        long[][] triangle = new long[arrayOfRows][arrayOfRows];       //The array has a long type so that you can create
                                                                      //huge pascal triangles. P.S. At first I wanted to
                                                                      //create a two-dimensional list, but not a single
                                                                      //example from the internet began to work for me

        /* double for loop to calculate triangle */
        for (int i = 0; i < arrayOfRows; i++) {
            for (int j = 0; j <= i; j++) {

                /* checking for the place of a number in a triangle and calculating the corresponding value */
                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j]; // formula for calculating a number in
                                                                                  // a triangle
                }

                /* printing our triangle */
                System.out.print(triangle[i][j] + " ");
            }

            /* creating new line */
            System.out.println();
        }
    }

    /* method for user input */
    public void enterStringsOfTriangle() {

        System.out.println("Введите количество строк треугольника Паскаля");

        /* creating an infinite input to get the correct value */
        while (true) {

            /* checking for new line */
            if (scanner.hasNext()) {

                /* checking for int number */
                if (scanner.hasNextInt()) {
                    arrayOfRows = scanner.nextInt(); // setting array size

                    /* checking if a number is positive because a triangle cannot be negative */
                    if (arrayOfRows > 0) {
                        break;
                    }

                /* Displaying a message on the screen with incorrect input
                P.S. for some reason this message throws into an endless loop and I don’t understand why */
                } else {
                    System.out.println("Введены неверные данные, повторите ввод снова!");
                }
            }
        }
    }
}
