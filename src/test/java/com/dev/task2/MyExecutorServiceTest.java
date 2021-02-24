package com.dev.task2;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyExecutorServiceTest {
    private MyExecutorService myExecutorService;
    private List<Integer> integerList;

    @BeforeEach
    void setUp() {
        integerList = Util.fillArray();
        myExecutorService = new MyExecutorService(integerList);
    }

    @Test
    void sum_Ok() {
        int actual = myExecutorService.execute();
        int expected = Util.listSum(integerList);
        assertEquals(expected, actual);
    }
}
