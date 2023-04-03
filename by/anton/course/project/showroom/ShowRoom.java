package by.anton.course.project.showroom;

import by.anton.course.project.Car;
import by.anton.course.project.cars.BusCar;
import by.anton.course.project.cars.TownCar;
import by.anton.course.project.cars.TruckCar;
import by.anton.course.project.components.*;
import by.anton.course.project.factory.Factory;
import by.anton.course.project.service.*;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShowRoom {
    private final Factory<TruckCar> truckFactory = new Factory<>(
            Arrays.asList(Model.MAZ, Model.MERCEDES),
            Arrays.asList(EngineCapacity.AVERAGE_VALUE, EngineCapacity.LARGE_VALUE),
            Arrays.asList(Color.WHITE, Color.RED, Color.BLUE),
            Arrays.asList(WheelSize.BIG, WheelSize.MEDIUM),
            Arrays.asList(Options.GPS, Options.AIRBAGS, Options.ABS, Options.ANTI_THEFT_SYSTEM),
            CarType.TRUCK
    );

    private final Factory<BusCar> busFactory = new Factory<>(
            Arrays.asList(Model.TOYOTA, Model.TOYOTA),
            Arrays.asList(EngineCapacity.AVERAGE_VALUE, EngineCapacity.LARGE_VALUE),
            Arrays.asList(Color.GREEN, Color.YELLOW),
            Arrays.asList(WheelSize.MEDIUM, WheelSize.BIG),
            Arrays.asList(Options.GPS, Options.GLONASS, Options.GLASS_PROTECTION, Options.ABS),
            CarType.BUS
    );

    private final Factory<TownCar> townCarFactory = new Factory<>(
            Arrays.asList(Model.TOYOTA, Model.MERCEDES, Model.VOLKSWAGEN),
            Arrays.asList(EngineCapacity.SMALL_VALUE, EngineCapacity.AVERAGE_VALUE),
            Arrays.asList(Color.BLUE, Color.WHITE, Color.GREEN, Color.RED),
            Arrays.asList(WheelSize.MEDIUM, WheelSize.SMALL),
            Arrays.asList(Options.AIRBAGS, Options.ANTI_THEFT_SYSTEM,
                    Options.TINTING, Options.GLASS_PROTECTION, Options.GPS),
            CarType.TOWN_CAR
    );

    private final ColorService colorService = new ColorService();
    private final OptionsService optionsService = new OptionsService();
    private final WheelService wheelService = new WheelService();

    public TruckCar orderCar(
            Model model, EngineCapacity engineCapacity,
            Color color, WheelSize wheelSize,
            List<Options> options,
            int cargoCapacity, String companyName
    ) {
        return truckFactory.createCarByOrder(model, engineCapacity, color, wheelSize, options, cargoCapacity, companyName);
    }

    public BusCar orderCar(
            Model model, EngineCapacity engineCapacity,
            Color color, WheelSize wheelSize,
            List<Options> options,
            int peopleCapacity
    ) {
        return busFactory.createCarByOrder(model, engineCapacity, color, wheelSize, options, peopleCapacity);
    }

    public TownCar orderCar(
            Model model, EngineCapacity engineCapacity,
            Color color, WheelSize wheelSize,
            List<Options> options,
            boolean isSport
    ) {
        return townCarFactory.createCarByOrder(model, engineCapacity, color, wheelSize, options, isSport);
    }

    public void changeColor(Car car, Color color) {
        colorService.change(car, color);
    }

    public void changeWheelSize(Car car, WheelSize wheelSize) {
        wheelService.change(car, wheelSize);
    }

    public void addOption(Car car, Options option) {
        optionsService.change(car, option);
    }

    public void deleteOption(Car car, Options option) {
        optionsService.deleteOption(car, option);
    }

    public void deleteOptions(Car car, List<Options> options) {optionsService.deleteOptions(car, options);}

    public void addOptions(Car car, List<Options> options) {
        car.addOptions(options);
    }

    public void addCarToStorage(TruckCar car) {
        truckFactory.addCarToStock(car);
    }

    public void addCarToStorage(BusCar car) {
        busFactory.addCarToStock(car);
    }

    public void addCarToStorage(TownCar car) {
        townCarFactory.addCarToStock(car);
    }

    public TruckCar getLastTruckInStorage() {
        return truckFactory.getLastTruckFromStorage();
    }

    public BusCar getLastBusInStorage() {
        return busFactory.getLastBusFromStorage();
    }

    public TownCar getLastTownCarInStorage() {
        return townCarFactory.getLastTownCarFromStorage();
    }

    public void displayAvailableParametersToSet(CarType carType) {
        switch (carType) {
            case TRUCK -> System.out.println(truckFactory.toString());
            case BUS -> System.out.println(busFactory.toString());
            case TOWN_CAR -> System.out.println(townCarFactory.toString());
            default -> System.out.println("Нет доступных параметров!");
        }
    }

    public void displayStock(CarType carType) {
        switch (carType) {
            case TRUCK -> System.out.println(truckFactory.toStockString(carType));
            case BUS -> System.out.println(busFactory.toStockString(carType));
            case TOWN_CAR -> System.out.println(townCarFactory.toStockString(carType));
            default -> System.out.println("Нет складов");
        }
    }

    public int getStockSize(CarType carType) {
        switch (carType) {
            case TRUCK -> {return truckFactory.getStockSize(carType);}
            case BUS -> { return busFactory.getStockSize(carType); }
            case TOWN_CAR -> { return townCarFactory.getStockSize(carType); }
            default -> { return 0; }
        }
    }

    public TruckCar getTruckByIndex(int index) {
        return truckFactory.getTruckCarByIndex(index);
    }

    public BusCar getBusByIndex(int index) {
        return busFactory.getBusCarByIndex(index);
    }

    public TownCar getTownCarByIndex(int index) {
        return townCarFactory.getTownCarByIndex(index);
    }
}
