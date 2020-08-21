package DesignPatterns.Structural.Composite;

public class Cashier implements Employee{
    private String name;
    public Cashier(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void add(Employee e){
    }
    public void print() {
        System.out.println("==========================");
        System.out.println("Name ="+getName());
        System.out.println("==========================");
    }
}
