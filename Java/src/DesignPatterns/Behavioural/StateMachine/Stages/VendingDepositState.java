package DesignPatterns.Behavioural.StateMachine.Stages;

import DesignPatterns.Behavioural.StateMachine.Vending;
import DesignPatterns.Behavioural.StateMachine.VendingWrapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VendingDepositState extends Vending {
    public void pull(VendingWrapper wrapper){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter money to deposit!");
            int money = Integer.parseInt(br.readLine());
            wrapper.setMoneyTotal(money);
        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        wrapper.setState(new VendingStockState());
        System.out.println("State changed to Stock!");
    }
}
