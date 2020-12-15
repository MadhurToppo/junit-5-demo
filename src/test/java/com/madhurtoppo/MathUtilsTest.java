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
        System.out.println("Started testing..." + testInfo.getDisplayName());
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
                () -> assertEquals(6, mathUtils.divide(48, 8)),
                () -> assertEquals(20, mathUtils.divide(-200, -10))
        );
    }

    @RepeatedTest(3)
    @DisplayName("Circle Area Test")
    @Tag("Circle")
    void testCircleArea() {
        assertEquals(314.1592653589793, mathUtils.circleArea(10));
        assertEquals(31415.926535897932, mathUtils.circleArea(100));
        assertEquals(3.141592653589793, mathUtils.circleArea(1));
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("Finished testing..." + testInfo.getDisplayName());
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("---Tearing down all---");
    }

}