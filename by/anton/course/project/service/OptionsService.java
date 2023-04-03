package by.anton.course.project.service;

import by.anton.course.project.Car;
import by.anton.course.project.Service;
import by.anton.course.project.components.Options;

import java.util.List;

public class OptionsService implements Service<List<Options>> {

    public void change(Car car, List<Options> optionsToAdd, List<Options> optionsToDelete) {
        car.changeOptions(optionsToDelete, optionsToAdd);
    }

    public void change(Car car, List<Options> optionsToAdd) {
        car.addOptions(optionsToAdd);
    }

    public void change(Car car, Options optionToAdd) {
        car.addOption(optionToAdd);
    }

    public void deleteOptions(Car car, List<Options> optionsToDelete) {
        car.changeOptions(optionsToDelete);
    }

    public void deleteOption(Car car, Options option) {
        car.deleteOption(option);
    }
}
