package DesignPatterns.Behavioural.StateMachine;

import DesignPatterns.Behavioural.StateMachine.Stages.VendingStockState;

public class VendingWrapper {
    public Vending state;
    public static int moneyTotal = 0;

    public int getMoneyTotal() {
        return moneyTotal;
    }

    public void setMoneyTotal(int moneyTotal) {
        this.moneyTotal += moneyTotal;
    }

    VendingWrapper(){
        state = new VendingStockState();
    }

    public void setState(Vending state){
        this.state = state;
    }

    public void pull(){
        state.pull(this);
    }
}
