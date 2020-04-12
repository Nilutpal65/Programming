package VendingMachine;

import java.util.List;

public interface VendingMachine {
    public int selectItemAndGetPrice(Item item);
    public void insertCoin(Coin coin);
    public List<Coin> refund();
    public Bucket<Item, List<Coin>> collectItemAndChange();
    public void reset();
    public int getTotalSales();
}
