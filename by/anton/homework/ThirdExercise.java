/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.homework;

/**
 * This class inverts an array
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class ThirdExercise {

    /** Main program logic */
    public static void main(String[] args) {
        int[] array = {32, 41, 4, 1, 5, 6, 6 ,8, 3, 24, 76};       // Array to be inverted

        /* Printing the original array */
        System.out.print("Массив без инверсии >> ");

        for (int i = 0; i < array.length; i++) {

            /* Finding out if we need a space */
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + " ");
            }
        }

        /* Array inversion */
        for (int i = 0; i < array.length / 2; i++) {               // Get the middle of the array
            int temp = array[i];                                   // Create temporarily variable
            array[i] = array[array.length - i - 1];                // Data transfer
            array[array.length - i - 1] = temp;                    // Return of temporary data to the place of inversion
        }

        /* Array printing */
        System.out.print("\nМассив после инверсии >> ");

        for (int i = 0; i < array.length; i++) {

            /* Finding out if we need a space */
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + " ");
            }
        }
    }
}
