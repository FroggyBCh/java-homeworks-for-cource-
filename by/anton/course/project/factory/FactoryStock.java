/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.course.project.factory;

import by.anton.course.project.utils.ListCompare;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * This class is required to create car storage
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */

public class FactoryStock<T> {
    private List<T> carList = new ArrayList<>();                    //car storage list
    private ListCompare<T> listCompare = new ListCompare<>();       //instance needed to compare lists

    /* the method needed to add a car to the storage */
    public void addCar(T car) {
        if (!this.carList.contains(car)) {
            this.carList.add(car);
        }
    }

    /* the method needed to add a list of cars to the warehouse */
    public void addCar(List<T> car) {
        if (!listCompare.compareLists(carList, car)) {
            this.carList.addAll(car);
        }
    }

    /* the method needed to receive vehicles from the warehouse */
    public List<T> takeCars() {
        return this.carList;
    }

    /* the method needed to get the last car from the list */
    public T takeCar() {
        T lastCar = this.carList.get(this.carList.size() - 1);
        this.carList.remove(this.carList.size() - 1);
        return lastCar;
    }

    /* method for getting a car by index */
    public T takeCar(int index) {
        T car = this.carList.get(index);
        this.carList.remove(index);
        return car;
    }

    /* method needed to receive string format cars in stock */
    @Override
    public String toString() {
        return "FactoryStock{" +
                "carList=" + carList +
                '}';
    }
}
