package com.dev.task2;

import java.util.ArrayList;
import java.util.List;

public class Util {
    private static final int CELLS_NUMBER = 1_000_000;

    public static List<Integer> fillArray() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < CELLS_NUMBER; i++) {
            list.add(1);
        }
        return list;
    }

    public static int listSum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }
}
