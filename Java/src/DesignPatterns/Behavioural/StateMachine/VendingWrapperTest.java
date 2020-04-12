package DesignPatterns.Behavioural.StateMachine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingWrapperTest {
    VendingWrapper vTest;
    @Before
    public void setUp() throws Exception {
        vTest = new VendingWrapper();
    }

    @After
    public void tearDown() throws Exception {
        vTest = null;
    }

    @Test
    public void getMoneyTotal() {
        assertEquals(0, vTest.getMoneyTotal());

        vTest.setMoneyTotal(10);
        assertEquals(10, vTest.getMoneyTotal());

        vTest.setMoneyTotal(10);
        assertEquals(20, vTest.getMoneyTotal());

        vTest.setMoneyTotal(10);
        assertEquals(30, vTest.getMoneyTotal());

        vTest.setMoneyTotal(10);
        assertEquals(40, vTest.getMoneyTotal());
    }

    @Test
    public void setMoneyTotal() {
    }
}