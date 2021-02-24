package com.dev.task2;

import java.util.List;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private List<Integer> list;

    public MyCallable(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() {
        return list.stream().reduce(0, Integer::sum);
    }
}
