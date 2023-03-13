package by.anton.homework5;

import by.anton.homework5.exercise1.TheFirstExercise;
import by.anton.homework5.exercise2.TheSecondExercise;
import by.anton.homework5.exercise3.TheThirdExercise;
import by.anton.homework5.exercise4.TheFourthExercise;
import by.anton.homework5.exercise5.TheFifthExercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TheFirstExercise first = new TheFirstExercise();
        TheSecondExercise second = new TheSecondExercise();
        TheThirdExercise third = new TheThirdExercise();
        TheFourthExercise fourth = new TheFourthExercise();
        TheFifthExercise fifth = new TheFifthExercise();

        System.out.println("Меню выбора заданий \nДля завершения ввода введите \"stop\" ");

        while (true) {
            System.out.print("Выберите номер задания >> ");

            if (scanner.hasNextLine()) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();



                    switch (number) {
                        case 1:
                            first.echoStrings(scanner);
                            break;
                        case 2:
                            second.calculationAverageValueOfNumbers(scanner);
                            break;
                        case 3:
                            third.enteringAndSortingList(scanner);
                            break;
                        case 4:
                            fourth.calculator(scanner);
                        case 5:
                            fifth.matrixAddition(scanner);
                        default:
                            System.out.println("Выбрано неверное число :(, попробуйте ввести номер задания заново");
                        }

                } else if (scanner.nextLine().equals("stop")) {
                    break;
                } else {
                    System.out.println("Введены неверные данные, повторите ввод снова!");
                }
            }
        }
    }
}
