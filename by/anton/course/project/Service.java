package by.anton.course.project;

import by.anton.course.project.components.Color;

public interface Service<T> {
    public void change(Car car, T variation );
}
