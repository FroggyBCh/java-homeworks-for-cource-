package by.anton.course.project.cars;

import by.anton.course.project.Car;
import by.anton.course.project.components.*;

import java.util.List;

public class BusCar extends Car {

    private int numberOfPassengers;

    public BusCar(Color color, Model model, WheelSize wheelSize,
                  EngineCapacity engineCapacity, List<Options> options, int numberOfPassengers) {

        super(color, model, wheelSize, engineCapacity, options);
        this.numberOfPassengers = numberOfPassengers;
    }

    public void setPassengersCapacity(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}

