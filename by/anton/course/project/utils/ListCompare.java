package by.anton.course.project.utils;

import java.util.List;

public class ListCompare<T> {

    public boolean compareLists(List<T> list1, List<T> list2) {
        for (T obj : list2) {
            if (!list1.contains(obj)) {
                return false;
            }
        }
        return true;
    }
}
