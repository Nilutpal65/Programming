package DesignPatterns.Structural.Decorator;

public class ChineseFood extends FoodDecorator {
    public ChineseFood(Food newFood){
        super(newFood);
    }
    public String prepareFood() {
        return super.prepareFood() + " With Chowmein!";
    }
    public double foodPrice() {
        return super.foodPrice() + 150.0;
    }
}
