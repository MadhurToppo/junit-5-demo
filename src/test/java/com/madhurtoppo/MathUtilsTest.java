package com.madhurtoppo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeAll
    static void beforeAllInit() {
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
            assertAll(
                    () -> assertEquals(16, mathUtils.add(12, 4)),
                    () -> assertEquals(56, mathUtils.add(48, 8)),
                    () -> assertEquals(24, mathUtils.add(13, 11)),
                    () -> assertEquals(0, mathUtils.add(0, 0))
            );
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
                () -> assertEquals(3, mathUtils.divide(12, 4)),
                () -> assertEquals(6, mathUtils.divide(48, 8)),
                () -> assertEquals(12, mathUtils.divide(132, 11)),
                () -> assertEquals(-5, mathUtils.divide(10, -2))
        );
    }

    @RepeatedTest(3)
    @DisplayName("Circle Area Test")
    @Tag("Circle")
    void testCircleArea() {
        assertEquals(314.1592653589793, mathUtils.circleArea(10));
        assertEquals(31415.926535897932, mathUtils.circleArea(100));
    }


    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("Finished..." + testInfo.getDisplayName());
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("---Tearing down all---");
    }

}