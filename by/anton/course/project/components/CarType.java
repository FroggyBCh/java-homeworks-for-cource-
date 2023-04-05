/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */
package by.anton.course.project.components;

import java.util.Arrays;

/**
 *
 * this enam is used as a crutch to determine the type of car because
 * I couldn't implement it without a crutch due to lack of time and lack of sleep
 * but that's my problem sorry for whining
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public enum CarType {
    TRUCK,
    BUS,
    TOWN_CAR;

    /* this method is used to display cars available for production */
    public static String returnString() {
        CarType[] carTypes = CarType.values();
        return Arrays.toString(carTypes);
    }
}
