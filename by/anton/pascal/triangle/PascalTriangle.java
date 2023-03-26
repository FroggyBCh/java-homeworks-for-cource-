/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.pascal.triangle;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * This class is used to input the number of lines
 * and output pascasl's triangle equal to the number of lines
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */

public class PascalTriangle {
    private static final Scanner scanner = new Scanner(System.in);    //Scanner is created to get number
                                                                      // of rows from the user
    private              int     arrayOfRows;                         //Variable to set the size of the array

    /* This method is used to calculate the triangle */
    public long[][] triangleCalculation() throws InterruptedException {
        long[][] triangle = new long[arrayOfRows][arrayOfRows];       //The array has a long type so that you can create
                                                                      //huge pascal triangles. P.S. At first I wanted to
                                                                      //create a two-dimensional list, but not a single
                                                                      //example from the internet began to work for me

        /* Double for loop to calculate triangle */
        for (int i = 0; i < arrayOfRows; i++) {
            for (int j = 0, k = i; j <= k; j++, k--) {

                /* Checking for the place of a number in a triangle and calculating the corresponding value */
                if (j == 0) {
                    triangle[i][j] = 1;
                    triangle[i][k] = 1;

                /* Filling an array at once from the beginning and end */
                } else {
                    if (j == k) {
                        triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j]; // Formula for calculating a number in
                                                                                      // a triangle
                    } else {
                        triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                        triangle[i][k] = triangle[i][j];
                    }

                }
            }
        }

        return triangle;
    }


    /* Outputting an array to the console */
    public void printingTheArray(long[][] triangle) {

        /* Creating a double loop for output */
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* Method for user input */
    public void enterStringsOfTriangle() {

        System.out.println("Введите количество строк треугольника Паскаля");

        /* Creating an infinite input to get the correct value */
        while (true) {

            /* Checking for new line */
            if (scanner.hasNext()) {

                /* Checking for int number */
                if (scanner.hasNextInt()) {
                    arrayOfRows = scanner.nextInt(); // Setting array size

                    /* Checking if a number is positive because a triangle cannot be negative */
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
