package DesignPatterns.Structural.Composite;

public class CompositePatternDemo {
    public static void main(String[] args) {
        Employee e1 = new Cashier("Nilutpal");
        Employee e2 = new Cashier("Rahul");
        Employee e3 = new Accountant("Priya");
        Employee e4 = new BankManager("Raj");
        e4.add(e1);
        e4.add(e2);
        e4.add(e3);
        e4.print();
    }
}
