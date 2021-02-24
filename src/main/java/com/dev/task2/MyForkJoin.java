package com.dev.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import org.apache.commons.collections4.ListUtils;

public class MyForkJoin {
    private static final int PARTITION_NUMBER = 5;
    private final List<Integer> integerList;

    public MyForkJoin(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public int execute() {
        List<List<Integer>> partitionList = ListUtils.partition(integerList, integerList.size()
                / PARTITION_NUMBER);
        List<MyRecursiveTask> myRecursiveTasks = new ArrayList<>(PARTITION_NUMBER);

        for (int i = 0; i < PARTITION_NUMBER; i++) {
            myRecursiveTasks.add(new MyRecursiveTask(partitionList.get(i)));
        }
        int sum = 0;
        Collection<MyRecursiveTask> recursiveTasks = ForkJoinTask.invokeAll(myRecursiveTasks);
        for (MyRecursiveTask task : recursiveTasks) {
            sum += task.join();
        }
        return sum;
    }
}
