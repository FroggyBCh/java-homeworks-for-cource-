/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.pascal.triangle;

/**
 *
 * Control class for working with pascal's triangle
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */

public class Main {

    /* Main program logic */
    public static void main(String[] args) throws InterruptedException {
        PascalTriangle triangle = new PascalTriangle();               //Ceating an instance of a class

        triangle.enterStringsOfTriangle();                            //Launching a method to receive data from the user
        triangle.printingTheArray(triangle.triangleCalculation());    //Triangle calculation and printing array
    }
}
