package by.anton.homework5.exercise1;

import java.util.Scanner;

public class TheFirstExercise {
    public void echoStrings(Scanner scanner) {
        System.out.println("Запуск первого задания, для завершения введите \"stop\"");

        while (true) {
            System.out.print(">> ");

            if (scanner.nextLine().equals("stop")) {
                break;
            } else {
                System.out.println(scanner.nextLine());
            }
        }
    }
}
