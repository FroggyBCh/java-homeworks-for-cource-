package by.anton.homework5.exercise5;

import java.util.Scanner;

public class TheFifthExercise {
    private double[][] matrix1 = new double[3][3];
    private double[][] matrix2 = new double[3][3];

    public void matrixAddition(Scanner scanner) {
        System.out.println("Задание №5 запущено, введите данные в матрицы или напишите \"stop\"");

        loop:
            while (true) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.println("Введите элемент " + i + " " + j + " первой матрицы");

                        while (true) {
                            if (scanner.hasNextLine()) {
                                if (scanner.hasNextDouble()) {
                                    matrix1[i][j] = scanner.nextDouble();
                                    break;
                                } else if (scanner.nextLine().equals("stop")) {
                                    break loop;
                                } else {
                                    System.out.println("Введено неверное число, введите число");
                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.println("Введите элемент " + i + " " + j + " второй матрицы");

                        while (true) {
                            if (scanner.hasNextLine()) {
                                if (scanner.hasNextDouble()) {
                                    matrix2[i][j] = matrix1[i][j] + scanner.nextDouble();
                                    break;
                                } else if (scanner.nextLine().equals("stop")) {
                                    break loop;
                                } else {
                                    System.out.println("Введено неверное число, введите число");
                                }
                            }
                        }
                    }
                }

                System.out.println("Результат сложения матриц >> ");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(matrix2[i][j] + "\t");
                    }
                    System.out.println();
                }
            }
    }
}
