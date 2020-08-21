package DesignPatterns.Structural.Composite;

import org.hamcrest.Condition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankManager implements Employee {
    private String name;
    List<Employee>employees = new ArrayList<>();
    public BankManager(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void add(Employee employee){
        employees.add(employee);
    }
    public void print() {
        System.out.println("==========================");
        System.out.println("Name ="+getName());
        System.out.println("==========================");

        Iterator<Employee> it = employees.iterator();

        while(it.hasNext())  {
            Employee employee = it.next();
            employee.print();
        }
    }
}
