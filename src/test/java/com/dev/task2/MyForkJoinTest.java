package com.dev.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyForkJoinTest {
    private static MyForkJoin myForkJoin;

    @BeforeEach
    void setUp() {
        myForkJoin = new MyForkJoin(Util.fillArray());
    }

    @Test
    void sum_Ok() {
        int expected = Util.listSum(Util.fillArray());
        int actual = myForkJoin.execute();
        assertEquals(expected, actual);
    }
}
