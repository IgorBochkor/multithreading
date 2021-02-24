package com.dev.task2;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyForkJoinTest {
    private MyForkJoin myForkJoin;
    private List<Integer> integerList;

    @BeforeEach
    void setUp() {
        integerList = Util.fillArray();
        myForkJoin = new MyForkJoin(integerList);
    }

    @Test
    void sum_Ok() {
        int expected = Util.listSum(integerList);
        int actual = myForkJoin.execute();
        assertEquals(expected, actual);
    }
}
