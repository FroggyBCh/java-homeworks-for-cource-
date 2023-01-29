/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.homework;

/**
 * The class is used to find the sum of array elements
 * not including any N.
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class FirstExercise {

    /** Main program logic */
    public static void main(String[] args) {
        int[] array = {3, 4, 5, 2, 1, 7, 7, 3, 1, 2, 8};       // an array that stores the elements for solving the task
        int   n = 3;                                           // number to avoid
        int   sum = 0;                                         // our future sum of elements

        /* Printing our array on display */
        System.out.print("Наш массив >> ");

        for (int i = 0; i < array.length; i++) {

            /* Finding out if we need a space */
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + " ");
            }
        }

        /* Printing n */
        System.out.println("\nНаше N >> " + n);

        /* Finding sum of elements without n */
        for (int i = 0; i < array.length; i++) {

            /* Validation against a value of n */
            if (array[i] != n) {
                sum +=array[i];
            }
        }

        /* Printing our result */
        System.out.println("Сумма элементов массива, не включая " + n + " >> " + sum);
    }
}

/*
 * I could solve this exercise using one for,
 * but I wanted to make the code more readable.
 */
