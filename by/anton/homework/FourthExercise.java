/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.homework;

/**
 * This class is designed to count the number of
 * positive and negative array elements.
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class FourthExercise {

    /** Main program logic */
    public static void main(String[] args) {
        int[][]  twoDimensionalArray = {{2, -3, 5}, {-7, -1, 6}, {2, 5, -1}};   // Two-dimensional array
        int      positiveCounter = 0;                                           // Positive number counter
        int      negativeCounter = 0;                                           // Negative number counter

        /* Printing and counting positive and negative elements of array */
        System.out.println("Двумерный массив >>");
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                System.out.print(twoDimensionalArray[i][j] + "\t");

                /* Check for negative and positive */
                if (twoDimensionalArray[i][j] > 0) {
                    ++positiveCounter;
                } else if (twoDimensionalArray[i][j] < 0) {
                    ++negativeCounter;
                }
            }
            System.out.println();
        }

        /* Output of positive and negative numbers */
        System.out.println("Количество положительных чисел >> " + positiveCounter);
        System.out.println("Количество отрицательных чисел >> " + negativeCounter);
    }
}
