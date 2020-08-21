package DesignPatterns.Structural.Adapter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

interface Player{
    public void assignWeapons(String weapons);
    public void mission();
}
class Terrorist implements Player{
    private final String Task;
    private String weapons;
    public Terrorist(){
        Task = "Plant a bomb";
    }
    public void assignWeapons(String weapons){
        this.weapons = weapons;
    }
    public void mission(){
        System.out.println("Terrorist Mission with weapon " + weapons);
    }
}
class CounterTerrorist implements Player{
    private final String Task;
    private String weapons;
    public CounterTerrorist(){
        Task = "Diffuse bomb";
    }
    public void assignWeapons(String weapons){
        this.weapons = weapons;
    }
    public void mission(){
        System.out.println("Counter - Terrorist Mission with weapon " + weapons);
    }
}
class PlayerFactory{
    private static Map<String, Player> hm = new HashMap<>();
    public static Player getPlayer(String type){
        Player p = null;
        if (hm.containsKey(type)) {
            p = hm.get(type);
        } else {
            switch (type){
                case "Terrorist":
                    // System.out.println("Terrorist Created!");
                    p = new Terrorist();
                    break;
                case "Counter-terrorist":
                    // System.out.println("Counter Terrorist Created!");
                    p = new CounterTerrorist();
                    break;
            }
            hm.put(type, p);
        }
        return p;
    }
}

public class CounterStrike {
    private static String[] playerType= {"Terrorist", "Counter-terrorist"};
    private static String[] weapons = {"AK-47", "Desert Eagle", "Maverick"};
    public static void main(String[] args){
        for (int i=0;i<5;++i) {
            Player p = PlayerFactory.getPlayer(getRandomPlayer());
            p.assignWeapons(getRandomWeapon());
            p.mission();
        }
    }
    public static String getRandomPlayer(){
        Random rand = new Random();
        return playerType[rand.nextInt(playerType.length)];
    }
    public static String getRandomWeapon(){
        Random rand = new Random();
        return weapons[rand.nextInt(weapons.length)];
    }

}
