package JUnitTest;

import static org.junit.Assert.*;

public class CalculatorTest {

    @org.junit.Test
    public void add() {
        Calculator ob = new Calculator();
        assertEquals(60, ob.add(10, 20, 30));
    }

    @org.junit.Test
    public void multiply() {
        Calculator ob = new Calculator();
        assertEquals(6000, ob.multiply(10, 20, 30));
    }
}