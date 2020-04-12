package VendingMachine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineImplTest {
    private static VendingMachine vm;
    @Before
    public void setUp() throws Exception {
        vm = new VendingMachineImpl();
    }

    @After
    public void tearDown() throws Exception {
        vm = null;
    }

    @Test
    public void selectItemAndGetPrice() {
    }

    @Test
    public void insertCoin() {
    }

    @Test
    public void refund() {
        int price = vm.selectItemAndGetPrice(Item.COKE);
        assertEquals(25, price);
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.NICKEL);
        vm.insertCoin(Coin.PENNY);
        vm.insertCoin(Coin.QUATER);
        assertEquals(41, vm.getTotalSales());
    }

    @Test
    public void getChange() {
    }

    @Test
    public void updateCashInventory() {
    }

    @Test
    public void collectItemAndChange() {
    }

    @Test
    public void reset() {
    }

    @Test
    public void getTotalSales() {
    }
}