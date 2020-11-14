package com.madhurtoppo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeAll
    void beforeAllInit() {
        System.out.println("---Initializing all---");
    }

    @BeforeEach
    void init(TestInfo testInfo) {
        mathUtils = new MathUtils();
        System.out.println("Started..." + testInfo.getDisplayName());
    }

    @Nested
    @Tag("Math")
    class testAdd {
        @Test
        @DisplayName("Addition Test for +ve")
        void testAddPositive() {
            assertEquals(7, mathUtils.add(3, 4), "The add method should add two numbers");
        }

        @Test
        @DisplayName("Addition Test for -ve")
        void testAddNegative() {
            assertEquals(-5, mathUtils.add(-2, -3), "The add method should add two numbers");
        }
    }

    @Test
    @DisplayName("Division Test")
//    @EnabledOnOs(OS.WINDOWS)
    @Tag("Math")
    void testDivide() {
        assertAll(
                () -> assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw"),
                () -> assertEquals(2, mathUtils.divide(4, 2))
        );
    }

    @RepeatedTest(3)
    @DisplayName("Circle Area Test")
    @Tag("Circle")
    void testCircleArea() {
        assertEquals(314.1592653589793, mathUtils.circleArea(10), "Should return correct circle area");
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("Finished..." + testInfo.getDisplayName());
    }

    @AfterAll
    void tearDownAll() {
        System.out.println("---Tearing down all---");
    }

//    @Test
//    @Disabled
    void testDisabled() {
        fail("This test is disabled");
    }
}