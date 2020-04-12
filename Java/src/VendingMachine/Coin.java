package VendingMachine;

public enum  Coin {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUATER(25);

    public int getValue() {
        return value;
    }

    private int value;
    private Coin(int value){
        this.value = value;
    }
}
