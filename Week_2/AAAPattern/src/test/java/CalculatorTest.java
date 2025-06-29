import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: Calculator initialized.");
    }

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator cleaned up.");
    }

    @Test
    public void testAddition() {

        int a = 10, b = 20;

        int result = calculator.add(a, b);

        assertEquals(30, result);
    }

    @Test
    public void testSubtraction() {

        int a = 20, b = 5;

        int result = calculator.subtract(a, b);

        assertEquals(15, result);
    }

    @Test
    public void testMultiplication() {

        int a = 3, b = 5;

        int result = calculator.multiply(a, b);

        assertEquals(15, result);
    }

    @Test
    public void testDivision() {

        int a = 30, b = 6;

        int result = calculator.divide(a, b);

        assertEquals(5, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionByZero() {
        int a = 10, b = 0;

        calculator.divide(a, b);
    }
}
