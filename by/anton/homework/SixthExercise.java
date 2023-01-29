/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.homework;

/**
 * This class is used to sum
 * and subtract matrices
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class SixthExercise {

    /** Main program logic */
    public static void main(String[] args) {
        int[][] firstMatrix = {{2, 3, 6}, {2, 7, 9}, {1, 4, 5}};        // The first matrix with data
        int[][] secondMatrix = {{1, 3, 5}, {8, 3, 1}, {2, 3, 3}};       // The second matrix with data
        int[][] sumMatrix = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};          // Matrix for the result of addition
        int[][] subtractMatrix = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};     // Matrix for the result of subtract

        /* Printing the first matrix */
        System.out.println("Первая матрица >> ");

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                System.out.print(firstMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        /* Printing the second matrix */
        System.out.println("Вторая матрица >> ");

        for (int i = 0; i < secondMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[i].length; j++) {
                System.out.print(secondMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        /* Sum and subtract of matrix */
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                sumMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
                subtractMatrix[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
            }
        }

        /* Printing result of matrix sum */
        System.out.println("Сумма матриц >> ");

        for (int i = 0; i < sumMatrix.length; i++) {
            for (int j = 0; j < sumMatrix[i].length; j++) {
                System.out.print(sumMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        /* Printing result of matrix subtract */
        System.out.println("Разность матриц >> ");

        for (int i = 0; i < subtractMatrix.length; i++) {
            for (int j = 0; j < subtractMatrix[i].length; j++) {
                System.out.print(subtractMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
