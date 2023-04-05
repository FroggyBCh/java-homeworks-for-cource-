/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */
package by.anton.course.project.cars;

import by.anton.course.project.Car;
import by.anton.course.project.components.*;

import java.util.List;

/**
 *
 * town car class
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class TownCar extends Car {

    private final boolean sportCar;             //the variable needed to establish whether the car is a sports car
    public TownCar(Color color, Model model, WheelSize wheelSize,
                   EngineCapacity engineCapacity, List<Options> options, boolean sportCar) {
        super(color, model, wheelSize, engineCapacity, options);
        this.sportCar = sportCar;
    }
}
