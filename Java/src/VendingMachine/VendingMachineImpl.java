package VendingMachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {
    private Inventory<Coin>cashInventory = new Inventory<Coin>();
    private Inventory<Item>itemInventory = new Inventory<Item>();
    private int totalSales;
    private Item currentItem;
    private int currentBalance;

    public VendingMachineImpl(){
        initialize();
    }


    private void initialize(){ //initialize machine with 5 coins of each denomination //and 5 cans of each Item
        for(Coin c : Coin.values()){
            cashInventory.put(c, 5);
        }
        for(Item i : Item.values()){
            itemInventory.put(i, 5);
        }
    }

    public int selectItemAndGetPrice(Item item) {
        if (itemInventory.hasItem(item)){
            currentItem = item;
            return currentItem.getValue();
        }
        throw new NotFullPaidException(" ", 0);
    }
    public void insertCoin(Coin coin) {
        currentBalance += coin.getValue();
        cashInventory.add(coin);
    }
    public List<Coin> refund(){
        List<Coin> refund = getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;

    }
    public List<Coin> getChange(int amount){
        List<Coin> changes = Collections.EMPTY_LIST;
        if(amount > 0){
            changes = new ArrayList<Coin>();
            long balance = amount;
            while(balance > 0){
                if(balance >= Coin.QUATER.getValue() && cashInventory.hasItem(Coin.QUATER)){
                    changes.add(Coin.QUATER);
                    balance = balance - Coin.QUATER.getValue();
                    continue;
                }else if(balance >= Coin.DIME.getValue() && cashInventory.hasItem(Coin.DIME)) {
                    changes.add(Coin.DIME);
                    balance = balance - Coin.DIME.getValue();
                    continue;
                }else if(balance >= Coin.NICKEL.getValue() && cashInventory.hasItem(Coin.NICKEL)) {
                    changes.add(Coin.NICKEL); balance = balance - Coin.NICKEL.getValue();
                    continue;
                }else if(balance >= Coin.PENNY.getValue() && cashInventory.hasItem(Coin.PENNY)) {
                    changes.add(Coin.PENNY); balance = balance - Coin.PENNY.getValue(); continue;
                }else{
                    throw new NotSufficientChangeException("NotSufficientChange, Please try another product");
                }
            }
        }
        return changes;
    }
    public void updateCashInventory(List<Coin> amount){
        for(Coin c : amount){
            cashInventory.remove(c);
        }
    }
    public Bucket<Item, List<Coin>> collectItemAndChange(){
        Item item = collectItem();
        totalSales = totalSales + currentItem.getValue();
        List<Coin> change = collectChange();
        return new Bucket<Item, List<Coin>>(item, change);
    }
    private List<Coin> collectChange() {
        int changeAmount = currentBalance - currentItem.getValue();
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        currentBalance = 0;
        currentItem = null;
        return change;
    }


    private Item collectItem() throws NotSufficientChangeException, NotFullPaidException{
        if(isFullPaid()){
            if(hasSufficientChange()){
                itemInventory.remove(currentItem);
                return currentItem;
            } throw new NotSufficientChangeException("Not Sufficient change in Inventory");
        }
        int remainingBalance = currentItem.getValue() - currentBalance;
        throw new NotFullPaidException("Price not full paid, remaining : ", remainingBalance);
    }

    private boolean hasSufficientChange(){
        return hasSufficientChangeForAmount(currentBalance - currentItem.getValue());
    }

    private boolean hasSufficientChangeForAmount(int amount) {
        boolean hasChange = true;
        try {
            getChange(amount);
        } catch (NotSufficientChangeException nsce) {
            return hasChange = false;
        }
        return hasChange;
    }

        private boolean isFullPaid() {
            if (currentBalance >= currentItem.getValue()) {
                return true;
            }
            return false;
        }

        public void reset () {
            cashInventory.clear();
            itemInventory.clear();
            totalSales = 0;
            currentItem = null;
            currentBalance = 0;
        }
        public int getTotalSales () {
            return currentBalance;
        }
}
