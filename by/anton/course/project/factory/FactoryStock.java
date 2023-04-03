package by.anton.course.project.factory;

import by.anton.course.project.Car;
import by.anton.course.project.utils.ListCompare;

import java.util.ArrayList;
import java.util.List;

public class FactoryStock<T> {
    private List<T> carList = new ArrayList<>();
    private ListCompare<T> listCompare = new ListCompare<>();

    public void addCar(T car) {
        if (!this.carList.contains(car)) {
            this.carList.add(car);
        }
    }

    public void addCar(List<T> car) {
        if (!listCompare.compareLists(carList, car)) {
            this.carList.addAll(car);
        }
    }

    public List<T> takeCars() {
        return this.carList;
    }

    public T takeCar() {
        T lastCar = this.carList.get(this.carList.size() - 1);
        this.carList.remove(this.carList.size() - 1);
        return lastCar;
    }

    public T takeCar(int index) {
        T car = this.carList.get(index);
        this.carList.remove(index);
        return car;
    }

    @Override
    public String toString() {
        return "FactoryStock{" +
                "carList=" + carList +
                '}';
    }
}
