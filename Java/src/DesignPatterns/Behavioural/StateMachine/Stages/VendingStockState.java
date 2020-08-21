package DesignPatterns.Behavioural.StateMachine.Stages;

import DesignPatterns.Behavioural.StateMachine.Vending;
import DesignPatterns.Behavioural.StateMachine.VendingWrapper;

public class VendingStockState extends Vending {
    public void pull(VendingWrapper wrapper){
        wrapper.setState(new VendingDepositState());
        System.out.println("State changed to Deposit!");
    }
}
