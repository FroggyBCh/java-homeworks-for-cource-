/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */
package by.anton.course.project.exceptions;

/**
 *
 * exception necessary for handling the absence of a car,
 * but due to rewriting of the code, it has lost its meaning
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class MissingCarsException extends Exception {
    public MissingCarsException(String message) {
        super(message);
    }
}
