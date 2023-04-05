/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */
package by.anton.course.project.exceptions;

/**
 *
 * an error needed to handle the absence of a car parameter,
 * but due to rewriting the code, it has lost its meaning
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class NoSuchCarParameter extends Exception {
    public NoSuchCarParameter(String message) {
        super(message);
    }
}
