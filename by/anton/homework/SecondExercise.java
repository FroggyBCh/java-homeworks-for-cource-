/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.homework;

/**
 * This class is used to find the sum of
 * even fibonacci numbers up to a certain n.
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class SecondExercise {

    /** Main program logic */
    public static void main(String[] args) {
        int   n = 10;                       // n to find numbers before that index
        int   sum = 0;                      // Sum of even Fibonacci numbers
        int[] fibonacciNumbers;             // Array for sequence of Fibonacci numbers

        fibonacciNumbers = new int[n];      // Determining the size of an array

        /* Printing Fibonacci array */
        System.out.print("Получившаяся последовательность >> ");

        /* Finding a sequence and its output */
        for (int i = 0; i < 10; i++) {

            /* Check for first and second number and printing it*/
            if (i == 0) {
                fibonacciNumbers[i] = 0;
                System.out.print(fibonacciNumbers[i] + " ");
                continue;
            } else if (i == 1) {
                fibonacciNumbers[i] = 1;
                System.out.print(fibonacciNumbers[i] + " ");
                continue;
            }

            /* Entering fibonacci numbers */
            fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];

            /* Checking if a space is needed in the output */
            if (i == fibonacciNumbers.length - 1) {
                System.out.print(fibonacciNumbers[i]);
            } else {
                System.out.print(fibonacciNumbers[i] + " ");
            }
        }

        /* Printing our n */
        System.out.println("\nОграничитель равен >> " + n);

        /* Finding the sum of even Fibonacci numbers */
        for (int i = 0; i < fibonacciNumbers.length; i++) {

            /* Parity check */
            if (fibonacciNumbers[i] % 2 == 0) {
                sum += fibonacciNumbers[i];
            }
        }

        /* Printing result */
        System.out.println("Результат >> " + sum);
    }
}
