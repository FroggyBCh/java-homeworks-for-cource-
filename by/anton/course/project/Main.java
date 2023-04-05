/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.course.project;

import by.anton.course.project.main.logic.Logic;

/**
 *
 * The main class in the whole structure
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */

public class Main {
    private static final Logic LOGIC = new Logic();             //an instance of the class with all the logic of the program

    /* main method */
    public static void main(String[] args) {
        try {
            LOGIC.mainLogic();                                  //program launch
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
