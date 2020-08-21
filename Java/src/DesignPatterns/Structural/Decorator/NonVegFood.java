package DesignPatterns.Structural.Decorator;

public class NonVegFood extends FoodDecorator{
    public NonVegFood(Food newFood){
        super(newFood);
    }
    public String prepareFood() {
        return super.prepareFood() + " With Roasted Chicken!";
    }
    public double foodPrice() {
        return super.foodPrice() + 100.0;
    }
}
