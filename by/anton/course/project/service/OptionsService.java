/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.course.project.service;

import by.anton.course.project.Car;
import by.anton.course.project.Service;
import by.anton.course.project.components.Options;

import java.util.List;


/**
 *
 * Class is used to change options in the car
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class OptionsService implements Service<List<Options>> {

    /* these methods are used to add remove options or all at once */
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
