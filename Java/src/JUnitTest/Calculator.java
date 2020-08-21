package JUnitTest;

public class Calculator {
    public int add(int... number) {
        int total = 0;
        for(int currentNumber: number){
            total+=currentNumber;
        }
        return total;
    }
    public int multiply(int... number) {
        int total = 1;
        for(int currentNumber: number){
            total*=currentNumber;
        }
        return total;
    }
}
