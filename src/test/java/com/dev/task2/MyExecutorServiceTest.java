package com.dev.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyExecutorServiceTest {
    private static MyExecutorService myExecutorService;

    @BeforeEach
    void setUp() {
        myExecutorService = new MyExecutorService(Util.fillArray());
    }

    @Test
    void sum_Ok() {
        int actual = myExecutorService.execute();
        int expected = Util.listSum(Util.fillArray());
        assertEquals(expected, actual);
    }
}
