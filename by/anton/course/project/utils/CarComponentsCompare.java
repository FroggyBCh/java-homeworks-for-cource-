package by.anton.course.project.utils;

import by.anton.course.project.components.*;

import java.util.List;

public class CarComponentsCompare {
    private List<Model> listOfModelsToCheck;
    private List<EngineCapacity> listOfEngineCapacitiesToCheck;
    private List<Color> listOfColorsToCheck;
    private List<WheelSize> listOfWheelSizesToCheck;
    private List<Options> listOfOptionsToCheck;
    private ListCompare<Options> listCompare = new ListCompare();

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
