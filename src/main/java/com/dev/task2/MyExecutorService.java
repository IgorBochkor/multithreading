package com.dev.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.commons.collections4.ListUtils;

public class MyExecutorService {
    private static final int THREAD_COUNT = 5;
    private static final int PARTITION_NUMBER = 5;
    private final List<Integer> integerList;

    public MyExecutorService(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public int execute() {
        List<List<Integer>> partitionList = ListUtils.partition(integerList, integerList.size()
                / PARTITION_NUMBER);
        List<Callable<Integer>> callableList = new ArrayList<>(PARTITION_NUMBER);

        for (int i = 0; i < PARTITION_NUMBER; i++) {
            callableList.add(new MyCallable(partitionList.get(i)));
        }
        return getListSum(callableList);
    }

    private int getListSum(List<Callable<Integer>> callableList) {
        int sum = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        try {
            List<Future<Integer>> futureList = executorService.invokeAll(callableList);
            for (Future<Integer> integerFuture : futureList) {
                sum += integerFuture.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Can't get sum from list ", e);
        }
        executorService.shutdownNow();
        return sum;
    }
}
