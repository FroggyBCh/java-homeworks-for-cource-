package by.anton.course.project.components;

import java.util.Arrays;

public enum CarType {
    TRUCK,
    BUS,
    TOWN_CAR;

    public static String returnString() {
        CarType[] carTypes = CarType.values();
        return Arrays.toString(carTypes);
    }
}
