package DesignPatterns.Structural.Adapter;
public class AdapterPatternDemo {
    public static void main(String[] args) {
        CreditCard targetInterface = new BankCustomer();
        targetInterface.giveBankDetails();
        targetInterface.getCreditCard();
    }
}
