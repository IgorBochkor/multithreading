package com.dev.task2;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
    private List<Integer> list;

    public MyRecursiveTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {
        return list.stream().reduce(0, Integer::sum);
    }
}
