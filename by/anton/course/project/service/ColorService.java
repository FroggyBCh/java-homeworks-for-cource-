/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */
package by.anton.course.project.service;

import by.anton.course.project.Car;
import by.anton.course.project.Service;
import by.anton.course.project.components.Color;


/**
 *
 * This class is used to change the color of the car
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class ColorService implements Service<Color> {

    /* the method is used to change the color of the car */
    public void change(Car car, Color variation) {
        car.setColor(variation);
    }
}
