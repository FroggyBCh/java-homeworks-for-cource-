/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.homework;

/**
 * This class checks if a matrix is
 * a lower triangular matrix
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class FifthExercise {

    /** Main program logic */
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0}, {1, 1, 0}, {1, 1, 1}};         // Triangle matrix
        int     sumForCheck = 0;                                    // This variable is used to check

        /* Printing elements of array */
        System.out.println("Треугольная матрица >>");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        /* Definition of matrix triangularity */
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                /* Checking for elements up to the main diagonal */
                if (j > i) {
                    sumForCheck += matrix[i][j];
                }
            }
        }

        /* Checking for zeros */
        if (sumForCheck == 0) {
            System.out.println("Это нижняя треугольная матрица");
        } else {
            System.out.println("Это не нижняя треугольная матрица");
        }
    }
}
