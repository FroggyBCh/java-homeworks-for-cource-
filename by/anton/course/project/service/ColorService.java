package by.anton.course.project.service;

import by.anton.course.project.Car;
import by.anton.course.project.Service;
import by.anton.course.project.cars.BusCar;
import by.anton.course.project.cars.TownCar;
import by.anton.course.project.cars.TruckCar;
import by.anton.course.project.components.Color;

public class ColorService implements Service<Color> {

    public void change(Car car, Color variation) {
        car.setColor(variation);
    }
}
