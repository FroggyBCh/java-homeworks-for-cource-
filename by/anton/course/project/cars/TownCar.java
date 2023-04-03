package by.anton.course.project.cars;

import by.anton.course.project.Car;
import by.anton.course.project.components.*;

import java.util.List;

public class TownCar extends Car {

    private final boolean sportCar;
    public TownCar(Color color, Model model, WheelSize wheelSize,
                   EngineCapacity engineCapacity, List<Options> options, boolean sportCar) {
        super(color, model, wheelSize, engineCapacity, options);
        this.sportCar = sportCar;
    }
}
