/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.course.project.service;

import by.anton.course.project.Car;
import by.anton.course.project.Service;
import by.anton.course.project.components.WheelSize;


/**
 *
 * the class is used to change the parameters of the wheels of the car
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class WheelService implements Service<WheelSize> {

    /* the method used to change the wheel */
    public void change(Car car, WheelSize variation) {
        car.setWheelSize(variation);
    }
}
