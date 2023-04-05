/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.course.project.utils;

import by.anton.course.project.components.*;

import java.util.List;

/**
 *
 * The class is needed to understand whether it is possible to install the car element
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */

public class CarComponentsCompare {
    private List<Model> listOfModelsToCheck;                        //list to check models
    private List<EngineCapacity> listOfEngineCapacitiesToCheck;     //engine checklist
    private List<Color> listOfColorsToCheck;                        //list of colors to check
    private List<WheelSize> listOfWheelSizesToCheck;                //wheel size list
    private List<Options> listOfOptionsToCheck;                     //list of options to check
    private ListCompare<Options> listCompare = new ListCompare();   //list of options to check

    /* constructor is used to get lists of components available for production */
    public CarComponentsCompare(
            List<Model> listOfModelsToCheck, List<EngineCapacity> listOfEngineCapacitiesToCheck,
            List<Color> listOfColorsToCheck, List<WheelSize> listOfWheelSizesToCheck,
            List<Options> listOfOptionsToCheck
    ) {
        this.listOfModelsToCheck = listOfModelsToCheck;
        this.listOfEngineCapacitiesToCheck = listOfEngineCapacitiesToCheck;
        this.listOfColorsToCheck = listOfColorsToCheck;
        this.listOfWheelSizesToCheck = listOfWheelSizesToCheck;
        this.listOfOptionsToCheck = listOfOptionsToCheck;
    }

    /* checking if the car component is in the lists */
    public boolean checkingCarComponentInTheList(
            Model model, EngineCapacity engineCapacity,
            Color color, WheelSize wheelSize,
            List<Options> options
            ) {
        return listOfModelsToCheck.contains(model) &&
                listOfEngineCapacitiesToCheck.contains(engineCapacity) &&
                listOfColorsToCheck.contains(color) &&
                listOfWheelSizesToCheck.contains(wheelSize) &&
                listCompare.compareLists(listOfOptionsToCheck, options);
    }

    /* method is used to compare the presence of a component in the list */
    public boolean componentCompare(Color component) {
        return listOfColorsToCheck.contains(component);
    }

    public boolean componentCompare(WheelSize component) {
        return listOfWheelSizesToCheck.contains(component);
    }

    public boolean componentCompare(Options option) {
        return listOfOptionsToCheck.contains(option);
    }
}
