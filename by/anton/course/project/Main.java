package by.anton.course.project;

import by.anton.course.project.main.logic.Logic;

public class Main {
    private static final Logic LOGIC = new Logic();

    public static void main(String[] args) {
        try {
            LOGIC.mainLogic();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
