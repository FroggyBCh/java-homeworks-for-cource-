package by.anton.course.project;

import by.anton.course.project.components.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Car {
    private Color color;
    private final Model model;
    private final static int productionYear = 2023;
    private WheelSize wheelSize;
    private final EngineCapacity engineCapacity;
    private List<Options> options = new ArrayList<>();

    public Car(Color color, Model model, WheelSize wheelSize,
               EngineCapacity engineCapacity, List<Options> options
    ) {
        this.color = color;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.wheelSize = wheelSize;
        this.options = options;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWheelSize(WheelSize wheelSize) {
        this.wheelSize = wheelSize;
    }

    public void changeOptions(List<Options> optionsToDelete, List<Options> optionsToSet) {

        for (Options option : optionsToDelete) {
            this.options.remove(option);
        }

        this.options.addAll(optionsToSet);
    }

    public void changeOptions(List<Options> optionsToDelete) {

        for (Options option : optionsToDelete) {
            this.options.remove(option);
        }
    }

    public void addOptions(List<Options> optionsToSet) {
        this.options.addAll(optionsToSet);
    }

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
    public void addOption(Options option) {
        options.add(option);
    }

    public void deleteOption(Options option) {
        options.remove(option);
    }

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
