package DesignPatterns.Structural.Decorator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecoratorPatternCustomer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int choice = Integer.parseInt(br.readLine());
        switch (choice) {
            case 1:
                VegFood vf = new VegFood();
                System.out.println(vf.foodPrice());
                System.out.println(vf.prepareFood());
                break;
            case 2:
                Food f1 = new NonVegFood(new VegFood());
                System.out.println(f1.foodPrice());
                System.out.println(f1.prepareFood());
                break;
            case 3:
                Food f2 = new ChineseFood(new VegFood());
                System.out.println(f2.foodPrice());
                System.out.println(f2.prepareFood());
                break;
            case 4:
                Food f3 = new ChineseFood(new NonVegFood(new VegFood()));
                System.out.println(f3.foodPrice());
                System.out.println(f3.prepareFood());
                default:
                    System.out.println("Exit");
        }
    }
}
