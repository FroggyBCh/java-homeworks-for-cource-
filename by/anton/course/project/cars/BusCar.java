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
 * bus class
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class BusCar extends Car {

    private int numberOfPassengers;     //variable needed for the number of passengers possible for transportation

    public BusCar(Color color, Model model, WheelSize wheelSize,
                  EngineCapacity engineCapacity, List<Options> options, int numberOfPassengers) {

        super(color, model, wheelSize, engineCapacity, options);
        this.numberOfPassengers = numberOfPassengers;
    }

    /* method is needed to determine the capacity of cars */
    public void setPassengersCapacity(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}

