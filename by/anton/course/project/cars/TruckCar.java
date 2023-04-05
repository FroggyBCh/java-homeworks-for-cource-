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
 * truck car class
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class TruckCar extends Car {

    private int     loadCapacity;                   //the variable needed to determine the capacity of a truck
    private String  truckCompanyName;               //the variable used to determine the name of the company that owns the truck

    public TruckCar(Color color, Model model, WheelSize wheelSize,
                    EngineCapacity engineCapacity, List<Options> options, int loadCapacity,
                    String truckCompanyName
    ) {
        super(color, model, wheelSize, engineCapacity, options);
        this.loadCapacity = loadCapacity;
        this.truckCompanyName = truckCompanyName;
    }

    /* methods are used to establish the capacity and name of the company */
    private void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    private void setTruckCompanyName(String truckCompanyName) {
        this.truckCompanyName = truckCompanyName;
    }
}
