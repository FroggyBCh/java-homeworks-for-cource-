package by.anton.course.project.cars;

import by.anton.course.project.Car;
import by.anton.course.project.components.*;

import java.util.List;

public class TruckCar extends Car {

    private int     loadCapacity;
    private String  truckCompanyName;

    public TruckCar(Color color, Model model, WheelSize wheelSize,
                    EngineCapacity engineCapacity, List<Options> options, int loadCapacity,
                    String truckCompanyName
    ) {
        super(color, model, wheelSize, engineCapacity, options);
        this.loadCapacity = loadCapacity;
        this.truckCompanyName = truckCompanyName;
    }

    private void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    private void setTruckCompanyName(String truckCompanyName) {
        this.truckCompanyName = truckCompanyName;
    }
}
