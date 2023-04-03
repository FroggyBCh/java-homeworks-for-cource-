/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.course.project.factory;

import by.anton.course.project.Car;
import by.anton.course.project.cars.*;
import by.anton.course.project.components.*;
import by.anton.course.project.utils.CarComponentsCompare;
import by.anton.course.project.utils.UserInput;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * This class is responsible for creating cars and changing their parameters.
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class Factory<T> {
    private final List<Model> models;
    private final List<EngineCapacity> engineCapacities;
    private final List<Color> colors;
    private final List<WheelSize> wheelSizes;
    private final List<Options> optionsList;
    private final CarType carType;                                     //a crutch for the correct operation of the program
    private static final FactoryStock<TruckCar> TRUCK_CAR_FACTORY_STOCK = new FactoryStock<>(); //And it's also crutch
    private static final FactoryStock<BusCar> BUS_CAR_FACTORY_STOCK = new FactoryStock<>();
    private static final FactoryStock<TownCar> TOWN_CAR_FACTORY_STOCK = new FactoryStock<>();
    private static final UserInput USER_INPUT = new UserInput();

    private final CarComponentsCompare compareComponents;       //checking for the presence of components from one list in another
    public Factory(List<Model> models, List<EngineCapacity> engineCapacities,
                   List<Color> colors, List<WheelSize> wheelSizes, List<Options> optionsList,
                   CarType carType
    ) {
        this.models = models;
        this.engineCapacities = engineCapacities;
        this.colors = colors;
        this.wheelSizes = wheelSizes;
        this.optionsList = optionsList;
        this.fillStorageWithCars(carType);
        this.compareComponents = new CarComponentsCompare(
                models,
                engineCapacities,
                colors,
                wheelSizes,
                optionsList
        );

        this.carType = carType;
    }


    public TruckCar createCarByOrder(Model model, EngineCapacity engineCapacity,
                                Color color, WheelSize wheelSize,
                                List<Options> options,
                                int loadCapacity, String companyName
    ) {


        if (
                compareComponents.checkingCarComponentInTheList(
                        model, engineCapacity, color,
                        wheelSize, options
                        )
        ) {
            for (TruckCar car : TRUCK_CAR_FACTORY_STOCK.takeCars()) {

                if (car.getModel() == model &&
                    car.getColor() == color &&
                    car.getWheelSize() == wheelSize &&
                    car.getEngineCapacity() == engineCapacity
                ) {
                    return car;
                }

            }
                return new TruckCar(color, model, wheelSize, engineCapacity, options, loadCapacity, companyName);
            }
        else {
            System.out.println("Переданы неверные значения для создания автомобиля!");
            return null;
        }
    }

    public BusCar createCarByOrder(Model model, EngineCapacity engineCapacity,
                                Color color, WheelSize wheelSize,
                                List<Options> options,
                                int passengersCapacity
    ) {

        if (
                compareComponents.checkingCarComponentInTheList(
                        model, engineCapacity, color,
                        wheelSize, options
                )
        ) {
            for (BusCar car : BUS_CAR_FACTORY_STOCK.takeCars()) {

                if (car.getModel() == model &&
                        car.getColor() == color &&
                        car.getWheelSize() == wheelSize &&
                        car.getEngineCapacity() == engineCapacity
                ) {
                    return car;
                }
            }
            return new BusCar(color, model, wheelSize, engineCapacity, options, passengersCapacity);
        }
        else {
            System.out.println("Переданы неверные значения для создания автомобиля!");
            return null;
        }
    }

    public TownCar createCarByOrder(Model model, EngineCapacity engineCapacity,
                                Color color, WheelSize wheelSize,
                                List<Options> options,
                                boolean isSportCar
    ) {

        if (
                compareComponents.checkingCarComponentInTheList(
                        model, engineCapacity, color,
                        wheelSize, options
                )
        ) {
                for (TownCar car : TOWN_CAR_FACTORY_STOCK.takeCars()) {

                    if (car.getModel() == model &&
                            car.getColor() == color &&
                            car.getWheelSize() == wheelSize &&
                            car.getEngineCapacity() == engineCapacity
                    ) {
                        return car;
                    }
                }
            return new TownCar(color, model, wheelSize, engineCapacity, options, isSportCar);
            }
        else {
                System.out.println("Переданы неверные значения для создания автомобиля!");
                return null;
        }

    }

    private void fillStorageWithCars(CarType type) {

        switch (type) {
            case TRUCK -> {
                List<Options> optionsToaddTruck = Arrays.asList(Options.GPS, Options.AIRBAGS);
                TRUCK_CAR_FACTORY_STOCK.addCar(
                        new TruckCar(
                                Color.WHITE, Model.MAZ, WheelSize.BIG, EngineCapacity.LARGE_VALUE,
                                optionsToaddTruck, 20, "Грузилкин"
                        )
                );
                TRUCK_CAR_FACTORY_STOCK.addCar(
                        new TruckCar(
                                Color.RED, Model.MERCEDES, WheelSize.BIG, EngineCapacity.AVERAGE_VALUE,
                                optionsToaddTruck, 15, "ГрузнOFF"
                        )
                );
            }
            case BUS -> {
                List<Options> optionsToAddBus = Arrays.asList(Options.GLONASS, Options.GPS);
                BUS_CAR_FACTORY_STOCK.addCar(
                        new BusCar(
                                Color.GREEN, Model.TOYOTA, WheelSize.BIG, EngineCapacity.AVERAGE_VALUE,
                                optionsToAddBus, 70
                        )
                );
                BUS_CAR_FACTORY_STOCK.addCar(
                        new BusCar(
                                Color.YELLOW, Model.MERCEDES, WheelSize.MEDIUM, EngineCapacity.AVERAGE_VALUE,
                                optionsToAddBus, 56
                        )
                );
            }
            case TOWN_CAR -> {
                List<Options> optionsToAddTownCar = Arrays.asList(Options.AIRBAGS, Options.TINTING);
                TOWN_CAR_FACTORY_STOCK.addCar(
                        new TownCar(
                                Color.WHITE, Model.VOLKSWAGEN, WheelSize.MEDIUM, EngineCapacity.AVERAGE_VALUE,
                                optionsToAddTownCar, true
                        )
                );
                TOWN_CAR_FACTORY_STOCK.addCar(
                        new TownCar(
                                Color.BLUE, Model.TOYOTA, WheelSize.SMALL, EngineCapacity.SMALL_VALUE,
                                optionsToAddTownCar, false
                        )
                );
            }
            default -> System.out.println("Возникли проблемы с заполнением склада");
        }

    }

    public void addCarToStock(TruckCar car) {
        TRUCK_CAR_FACTORY_STOCK.addCar(car);
    }

    public void addCarToStock(BusCar car) {
        BUS_CAR_FACTORY_STOCK.addCar(car);
    }

    public void addCarToStock(TownCar car) {
        TOWN_CAR_FACTORY_STOCK.addCar(car);
    }

    public TruckCar getLastTruckFromStorage() {
        return TRUCK_CAR_FACTORY_STOCK.takeCar();
    }

    public BusCar getLastBusFromStorage() {
        return BUS_CAR_FACTORY_STOCK.takeCar();
    }

    public TownCar getLastTownCarFromStorage() {
        return TOWN_CAR_FACTORY_STOCK.takeCar();
    }

    @Override
    public String toString() {
        switch (carType) {
            case TRUCK -> {
                return "Factory{" +
                        "models=" + models +
                        ", engineCapacities=" + engineCapacities +
                        ", colors=" + colors +
                        ", wheelSizes=" + wheelSizes +
                        ", stock=" + TRUCK_CAR_FACTORY_STOCK.takeCars() +
                        '}';
            }
            case BUS -> {
                return "Factory{" +
                        "models=" + models +
                        ", engineCapacities=" + engineCapacities +
                        ", colors=" + colors +
                        ", wheelSizes=" + wheelSizes +
                        ", stock=" + BUS_CAR_FACTORY_STOCK.takeCars() +
                        '}';
            }
            case TOWN_CAR -> {
                return "Factory{" +
                        "models=" + models +
                        ", engineCapacities=" + engineCapacities +
                        ", colors=" + colors +
                        ", wheelSizes=" + wheelSizes +
                        ", stock=" + TOWN_CAR_FACTORY_STOCK.takeCars() +
                        '}';
            }

            default -> {
                return "ERROR";
            }
        }
    }

    public String toStockString(CarType carType) {
        switch (carType) {
            case TRUCK -> { return TRUCK_CAR_FACTORY_STOCK.toString(); }
            case BUS -> { return BUS_CAR_FACTORY_STOCK.toString(); }
            case TOWN_CAR -> { return TOWN_CAR_FACTORY_STOCK.toString(); }
            default -> { return null; }
        }
    }

    public int getStockSize(CarType carType) {
        switch (carType) {
            case TRUCK -> { return TRUCK_CAR_FACTORY_STOCK.takeCars().size(); }
            case BUS -> { return BUS_CAR_FACTORY_STOCK.takeCars().size(); }
            case TOWN_CAR -> { return TOWN_CAR_FACTORY_STOCK.takeCars().size(); }
            default -> { return 0; }
        }
    }

    public TruckCar getTruckCarByIndex(int index) {
        return TRUCK_CAR_FACTORY_STOCK.takeCar(index);
    }

    public BusCar getBusCarByIndex(int index) {
        return BUS_CAR_FACTORY_STOCK.takeCar(index);
    }

    public TownCar getTownCarByIndex(int index) {
        return TOWN_CAR_FACTORY_STOCK.takeCar(index);
    }
}
