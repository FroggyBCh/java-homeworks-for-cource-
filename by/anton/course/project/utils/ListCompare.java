/*
 * %W% %E% Anton Punko
 *
 * Copyright (c) 2023 GNU GPL, Inc. All Rights Reserved
 */

package by.anton.course.project.utils;

import java.util.List;

/**
 *
 * the class needed to compare the elements of one list with the elements of the second,
 * that is, to search for elements of the second list in the first
 *
 * @version    19.0.1 2022-10-18
 * @author     Anton Punko
 */

public class ListCompare<T> {

    /* the method compares the presence of elements */
    public boolean compareLists(List<T> list1, List<T> list2) {
        for (T obj : list2) {
            if (!list1.contains(obj)) {
                return false;
            }
        }
        return true;
    }
}
