package VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {
    private Map<T, Integer>inventory = new HashMap<T, Integer>();

    public int getQuantity(T item){
        Integer value = inventory.get(item);
        return (value==null)?0:value;
    }
    public void add(T item){
        int count = inventory.get(item);
        inventory.put(item, count+1);
    }
    public void remove(T item){
        if (inventory.containsKey(item)) {
            int count = inventory.get(item);
            inventory.put(item, count-1);
        }
    }
    public Boolean hasItem(T item){
        return (getQuantity(item) > 0);
    }
    public void put(T item, int quantity){
        inventory.put(item, quantity);
    }
    public void clear(){
        inventory.clear();
    }
}
