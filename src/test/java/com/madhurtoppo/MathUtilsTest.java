package com.madhurtoppo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void addTest() {
        MathUtils mathUtils = new MathUtils();
        int expected = 7;
        int actual = mathUtils.add(3, 4);
        assertEquals(expected, actual, "The add method should add two numbers");
    }
}