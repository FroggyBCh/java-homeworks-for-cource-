/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.course.project;

/**
 *
 * Service interface providing a method for changing a car parameter
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */

public interface Service<T> {

    /* method that allows you to change the parameter of the car */
    public void change(Car car, T variation );
}
