package DesignPatterns.Builder;

import java.util.ArrayList;
import java.util.List;

public class CDType {
    private List<Packing>items = new ArrayList<>();
    public void addItems(Packing item) {
        items.add(item);
    }
    public void getCost() {
        for (Packing pack:items) {
            pack.price();
        }
    }
    public void showNames() {
        for (Packing pack:items) {
            System.out.println(pack.pack());
            System.out.println(pack.price());
            System.out.println("******");
        }
    }
}
