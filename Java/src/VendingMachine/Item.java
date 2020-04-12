package VendingMachine;

public enum Item {
    COKE("Coke", 25),
    PEPSI("Pepsi", 35),
    SODA("Soda", 45);

    private String key;
    private int value;

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    private Item(String key, int value){
        this.key = key;
        this.value = value;
    }

}
