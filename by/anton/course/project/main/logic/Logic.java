/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */
package by.anton.course.project.main.logic;

import by.anton.course.project.cars.BusCar;
import by.anton.course.project.cars.TownCar;
import by.anton.course.project.cars.TruckCar;
import by.anton.course.project.components.*;
import by.anton.course.project.showroom.ShowRoom;
import by.anton.course.project.utils.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * This class is used to create a user interface and work with it
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */
public class Logic {
    private static final ShowRoom showRoom = new ShowRoom();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final UserInput USER_INPUT = new UserInput();            //this thing is used to simplify the code
                                                                            //and handle user input

    /* these constants are needed to display messages to the user */
    private static final String GREETING_USER_MESSAGE = "Добро пожаловать в систему управления заводом!";
    private static final String REGULAR_USER_CHOICE_MESSAGE = "Сделайте ваш выбор(нажимайте нужную цифру в " +
            "зависимости от количества элементов в списке)";
    private static final String CHOOSE_WHAT_TO_CREATE_MESSAGE = "Выберите тип автомобиля, который вы хотите создать";
    private static final String ENTER_MODEL_MESSAGE = "Введите модель";
    private static final String ENTER_COLOR_MESSAGE = "Введите цвет";
    private static final String ENTER_ENGINE_CAPACITY = "Введите обьём двигателя";
    private static final String ENTER_WHEEL_SIZE = "Введите размер колёс";
    private static final String ENTER_OPTION = "Введите опцию";
    private static final String ENTER_CAPACITY = "Введите вместимость";
    private static final String ENTER_COMPANY_NAME = "Введите название компании";
    private static final String ENTER_IS_SPORT_CAR = "Ваша машина спортивная?";
    private static final String IS_NECESSARY_TO_CONTINUE = "Продолжаем?";
    private static final String ERROR = "Технические шоколадки";
    private static final String PARTING = "Пакеда!";
    private static final String SERVICE_SELECTION = "Изменить цвет, размер колёс, опции, закончить с этим";
    private static final String DELETE_OR_ADD = "Удалить или сохранять?";
    private static final String ERROR_PARAMETR_ENTER = "Неверный ввод параметра!";
    private static final String CHOOSE_WHAT_TO_DO = "Вы хотите создать машину, произвести её апгрейд," +
            " просмотреть склад, или вернуться в начало?";

    /* main method for working with the user */
    public void mainLogic() {
        System.out.println(GREETING_USER_MESSAGE);
        System.out.println(REGULAR_USER_CHOICE_MESSAGE);

        boolean runningProgram = true;
        int userInput;                      //variables for processing numbers entered by the user
        int us_in;

        /* main loop of the program */
        while (runningProgram) {
            System.out.println(CHOOSE_WHAT_TO_CREATE_MESSAGE);
            System.out.println(CarType.returnString());

            userInput = USER_INPUT.getNumber(SCANNER, 4);   //receiving a number from the user and the number
                                                                    //4 determines the number of options
            /* vehicle type selection */
            switch (userInput) {
                case 1:
                    System.out.println(CHOOSE_WHAT_TO_DO);
                    us_in = USER_INPUT.getNumber(SCANNER, 4);

                    /* user choice what to do with the car */
                    switch (us_in) {
                        case 1 -> createCar(CarType.TRUCK);
                        case 2 -> changeMachineParameter(CarType.TRUCK);
                        case 3 -> displayCarStock(CarType.TRUCK);
                        case 4 -> System.out.println();
                    }

                    break;
                case 2:
                    System.out.println(CHOOSE_WHAT_TO_DO);
                    us_in = USER_INPUT.getNumber(SCANNER, 4);

                    switch (us_in) {
                        case 1 -> createCar(CarType.BUS);
                        case 2 -> changeMachineParameter(CarType.BUS);
                        case 3 -> displayCarStock(CarType.BUS);
                        case 4 -> System.out.println();
                    }

                    break;
                case 3:
                    System.out.println(CHOOSE_WHAT_TO_DO);
                    us_in = USER_INPUT.getNumber(SCANNER, 4);

                    switch (us_in) {
                        case 1 -> createCar(CarType.TOWN_CAR);
                        case 2 -> changeMachineParameter(CarType.TOWN_CAR);
                        case 3 -> displayCarStock(CarType.TOWN_CAR);
                        case 4 -> System.out.println();
                    }

                    break;

                /* end of the program */
                case 4:
                    System.out.println(PARTING);
                    runningProgram = false;
                    break;
                default:
                    System.out.println(ERROR);
            }
        }
    }

    /* method needed to create a car */
    private void createCar(CarType carType) {
        boolean runningMain = true;


        while (runningMain) {

            /* try block needed to protect against input errors */
            try {
                /* user input of vehicle parameters */
                displayAvailableParametersToSet(carType);

                System.out.println(ENTER_MODEL_MESSAGE);
                Model model = Model.valueOf(USER_INPUT.getString(SCANNER));

                System.out.println(ENTER_ENGINE_CAPACITY);
                EngineCapacity engineCapacity = EngineCapacity.valueOf(USER_INPUT.getString(SCANNER));

                System.out.println(ENTER_WHEEL_SIZE);
                WheelSize wheelSize = WheelSize.valueOf(USER_INPUT.getString(SCANNER));

                System.out.println(ENTER_COLOR_MESSAGE);
                Color color = Color.valueOf(USER_INPUT.getString(SCANNER));

                List<Options> options = Logic.enterOptions();           //entering vehicle options

                /* switch is used to set specific car parameters */
                switch (carType) {
                    case TRUCK -> {
                        System.out.println(ENTER_CAPACITY);
                        int cargoCapacity = USER_INPUT.getInt(SCANNER);

                        System.out.println(ENTER_COMPANY_NAME);

                        String companyName = USER_INPUT.getString(SCANNER);
                        TruckCar truck = showRoom.orderCar(model, engineCapacity, color, wheelSize,
                                options, cargoCapacity, companyName);
                        showRoom.addCarToStorage(truck);

                        runningMain = false;
                    }
                    case BUS -> {
                        System.out.println(ENTER_CAPACITY);

                        int peopleCapacity = USER_INPUT.getInt(SCANNER);

                        BusCar busCar = showRoom.orderCar(model, engineCapacity, color, wheelSize, options, peopleCapacity);
                        showRoom.addCarToStorage(busCar);

                        runningMain = false;
                    }
                    case TOWN_CAR -> {
                        System.out.println(ENTER_IS_SPORT_CAR);

                        boolean isSport;
                        int isSprt = USER_INPUT.getNumber(SCANNER, 2);

                        isSport = isSprt == 1;

                        TownCar townCar = showRoom.orderCar(model, engineCapacity, color, wheelSize, options, isSport);
                        showRoom.addCarToStorage(townCar);

                        runningMain = false;
                    }
                    default -> System.out.println(ERROR);
                }
            } catch (Exception e) {
                System.out.println(ERROR_PARAMETR_ENTER);
                continue;
            }

        }

    }

    private static List<Options> enterOptions() {
        boolean running = true;
        List<Options> optionsList = new ArrayList<>();

        while (running) {
            System.out.println(ENTER_OPTION);
            Options option = Options.valueOf(USER_INPUT.getString(SCANNER));

            optionsList.add(option);

            System.out.println(IS_NECESSARY_TO_CONTINUE);
            int usr_input = USER_INPUT.getNumber(SCANNER, 2);
            if (usr_input == 1) {
                continue;
            } else {
                running = false;
            }
        }
        return optionsList;
    }

    /* car parameter change */
    private void changeMachineParameter(CarType carType) {
        int carForChangeParameter = chooseRightCar(carType);

        TruckCar truck = null;
        BusCar bus = null;
        TownCar townCar = null;

        boolean running = true;

        /* loop used to select and change a vehicle parameter */
        while (running) {
            System.out.println(REGULAR_USER_CHOICE_MESSAGE);
            System.out.println(SERVICE_SELECTION);

            int usrChoice = USER_INPUT.getNumber(SCANNER, 4);

            /* selection of a parameter to change check the type of car and set this parameter to it */
            switch (usrChoice) {
                case 1 -> {
                    System.out.println(ENTER_COLOR_MESSAGE);
                    Color color = Color.valueOf(USER_INPUT.getString(SCANNER));

                    switch (carType) {
                        case TRUCK -> {
                            truck = showRoom.getTruckByIndex(carForChangeParameter);
                            showRoom.changeColor(truck, color);
                            showRoom.addCarToStorage(truck);
                        }

                        case BUS -> {
                            bus = showRoom.getBusByIndex(carForChangeParameter);
                            showRoom.changeColor(bus, color);
                            showRoom.addCarToStorage(bus);
                        }
                        case TOWN_CAR -> {
                            townCar = showRoom.getTownCarByIndex(carForChangeParameter);
                            showRoom.changeColor(townCar, color);
                            showRoom.addCarToStorage(townCar);
                        }
                    }
                }
                case 2 -> {
                    System.out.println(ENTER_WHEEL_SIZE);
                    WheelSize wheelSize = WheelSize.valueOf(USER_INPUT.getString(SCANNER));

                    switch (carType) {
                        case TRUCK -> {
                            truck = showRoom.getTruckByIndex(carForChangeParameter);
                            showRoom.changeWheelSize(truck, wheelSize);
                            showRoom.addCarToStorage(truck);
                        }

                        case BUS -> {
                            bus = showRoom.getBusByIndex(carForChangeParameter);
                            showRoom.changeWheelSize(bus, wheelSize);
                            showRoom.addCarToStorage(bus);
                        }
                        case TOWN_CAR -> {
                            townCar = showRoom.getTownCarByIndex(carForChangeParameter);
                            showRoom.changeWheelSize(townCar, wheelSize);
                            showRoom.addCarToStorage(townCar);
                        }
                    }
                }
                /* case in which the options are changed */
                case 3 -> {
                    System.out.println(REGULAR_USER_CHOICE_MESSAGE);
                    System.out.println(DELETE_OR_ADD);
                    List<Options> options = new ArrayList<>();

                    usrChoice = USER_INPUT.getNumber(SCANNER, 2);

                    System.out.println(REGULAR_USER_CHOICE_MESSAGE);

                    /* here there is a choice to remove and add an option and then setting it to this parameter */
                    switch (usrChoice) {
                        case 1 -> {
                            boolean runningChoice = true;

                            /* input options */
                            while (runningChoice) {
                                System.out.println(ENTER_OPTION);

                                String usr_inp = USER_INPUT.getString(SCANNER);
                                if (Objects.equals(usr_inp, "STOP")) {
                                    runningChoice = false;
                                } else {
                                    options.add(Options.valueOf(USER_INPUT.getString(SCANNER)));
                                }
                            }

                            /* setting options for the desired type of car */
                            switch (carType) {
                                case TRUCK -> {
                                    truck = showRoom.getTruckByIndex(carForChangeParameter);
                                    showRoom.addOptions(truck, options);
                                    showRoom.addCarToStorage(truck);
                                }
                                case BUS -> {
                                    bus = showRoom.getBusByIndex(carForChangeParameter);
                                    showRoom.addOptions(bus, options);
                                    showRoom.addCarToStorage(bus);
                                }
                                case TOWN_CAR -> {
                                    townCar = showRoom.getTownCarByIndex(carForChangeParameter);
                                    showRoom.addOptions(townCar, options);
                                    showRoom.addCarToStorage(townCar);
                                }
                                default -> System.out.println(ERROR);
                            }

                        }
                        case 2 -> {
                            boolean runningChoice = true;

                            while (runningChoice) {
                                System.out.println(ENTER_OPTION);

                                String usr_inp = USER_INPUT.getString(SCANNER);
                                if (Objects.equals(usr_inp, "STOP")) {
                                    runningChoice = false;
                                } else {
                                    options.add(Options.valueOf(USER_INPUT.getString(SCANNER)));
                                }
                            }

                            switch (carType) {
                                case TRUCK -> {
                                    truck = showRoom.getTruckByIndex(carForChangeParameter);
                                    showRoom.deleteOptions(truck, options);
                                    showRoom.addCarToStorage(truck);
                                }
                                case BUS -> {
                                    bus = showRoom.getBusByIndex(carForChangeParameter);
                                    showRoom.deleteOptions(bus, options);
                                    showRoom.addCarToStorage(bus);
                                }
                                case TOWN_CAR -> {
                                    townCar = showRoom.getTownCarByIndex(carForChangeParameter);
                                    showRoom.deleteOptions(townCar, options);
                                    showRoom.addCarToStorage(townCar);
                                }
                                default -> System.out.println(ERROR);
                            }
                        }
                    }
                }
                case 4 -> {
                    System.out.println(PARTING);
                    running = false;
                }

            }
        }
    }

    /* output of parameters available for setting */
    private void displayAvailableParametersToSet(CarType carType) {
        switch (carType) {
            case TRUCK -> showRoom.displayAvailableParametersToSet(carType);
            case BUS -> showRoom.displayAvailableParametersToSet(carType);
            case TOWN_CAR -> showRoom.displayAvailableParametersToSet(carType);
        }
    }

    /* machine warehouse display */
    private void displayCarStock(CarType carType) {
        showRoom.displayStock(carType);
    }

    /* choosing the right vehicle */
    private int chooseRightCar(CarType carType) {
        displayCarStock(carType);
        System.out.println(REGULAR_USER_CHOICE_MESSAGE);

        int userInput = USER_INPUT.getNumber(SCANNER, showRoom.getStockSize(carType));

        return userInput - 1;
    }
}
