/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.course.project;

import by.anton.course.project.components.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * abstract class needed to create the basis of car classes
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */

public abstract class Car {
    private Color color;                                            //car color
    private final Model model;                                      //Car model
    private final static int productionYear = 2023;                 //year of car production
    private WheelSize wheelSize;                                    //car wheel size
    private final EngineCapacity engineCapacity;                    //car engine size
    private List<Options> options = new ArrayList<>();              //car options list

    /* passing car parameters to the constructor */
    public Car(Color color, Model model, WheelSize wheelSize,
               EngineCapacity engineCapacity, List<Options> options
    ) {
        this.color = color;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.wheelSize = wheelSize;
        this.options = options;
    }

    /* method to change car color */
    public void setColor(Color color) {
        this.color = color;
    }

    /* method for changing car wheel size */
    public void setWheelSize(WheelSize wheelSize) {
        this.wheelSize = wheelSize;
    }

    /* method needed to change vehicle options */
    public void changeOptions(List<Options> optionsToDelete, List<Options> optionsToSet) {

        for (Options option : optionsToDelete) {
            this.options.remove(option);
        }

        this.options.addAll(optionsToSet);
    }

    /* method needed to remove options */
    public void changeOptions(List<Options> optionsToDelete) {

        for (Options option : optionsToDelete) {
            this.options.remove(option);
        }
    }

    /* the method needed to add options to the car */
    public void addOptions(List<Options> optionsToSet) {
        this.options.addAll(optionsToSet);
    }

    /* methods for getting car parameters */
    public Color getColor() {
        return color;
    }

    public Model getModel() {
        return model;
    }

    public WheelSize getWheelSize() {
        return wheelSize;
    }

    public EngineCapacity getEngineCapacity() {
        return engineCapacity;
    }

    public List<Options> getOptions() {
        return options;
    }

    /* method needed to add one option */
    public void addOption(Options option) {
        options.add(option);
    }

    /* method needed to remove one option */
    public void deleteOption(Options option) {
        options.remove(option);
    }

    /* the method needed to represent the car in string format */
    @Override
    public String toString() {
        return "Car{" +
                "color=" + color +
                ", model=" + model +
                ", productionYear=" + productionYear +
                ", wheelSize=" + wheelSize +
                ", engineCapacity=" + engineCapacity +
                ", options=" + options +
                '}';
    }
}
