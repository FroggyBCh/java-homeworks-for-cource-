package by.anton.course.project.service;

import by.anton.course.project.Car;
import by.anton.course.project.Service;
import by.anton.course.project.components.WheelSize;

public class WheelService implements Service<WheelSize> {

    public void change(Car car, WheelSize variation) {
        car.setWheelSize(variation);
    }
}
