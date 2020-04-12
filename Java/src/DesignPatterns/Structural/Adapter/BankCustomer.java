package DesignPatterns.Structural.Adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BankCustomer extends BankDetails implements CreditCard {
    public void giveBankDetails() {
        // BankDetails ob1 = new BankDetails();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter Customer Name");
            String name = br.readLine();
            setAccHolderName(name);

            System.out.println("Enter Customer Account Number");
            long number = Long.parseLong(br.readLine());
            setAccNumber(number);

            System.out.println("Enter Bank Name");
            String bankName = br.readLine();
            setBankName(bankName);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
    public void getCreditCard() {
        System.out.println(getAccHolderName());
        System.out.println(getAccNumber());
        System.out.println(getBankName());
    }
}
