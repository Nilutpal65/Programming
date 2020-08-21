package DesignPatterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface Prototype {
    public Prototype getClone();
}
class EmployeeRecord implements Prototype {
    private int id;
    private String name;
    private double salary;

    EmployeeRecord() {

    }

    EmployeeRecord(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void showRecord(){
        System.out.println(id);
        System.out.println(name);
        System.out.println(salary);
        System.out.println("-------");
    }

    public Prototype getClone() {
        return new EmployeeRecord(id, name, salary);
    }
}
public class ProtoTypeDemo {
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Employee Id: ");
        int eid=Integer.parseInt(br.readLine());

        System.out.println("Enter Employee Name: ");
        String ename=br.readLine();

        System.out.println("Enter Employee Salary: ");
        double esalary= Double.parseDouble(br.readLine());

        EmployeeRecord e1=new EmployeeRecord(eid,ename,esalary);

        e1.showRecord();
        System.out.println(" ");
        EmployeeRecord e2=(EmployeeRecord) e1.getClone();
        e2.showRecord();
    }
}
