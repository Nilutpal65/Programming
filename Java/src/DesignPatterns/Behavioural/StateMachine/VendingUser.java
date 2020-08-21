package DesignPatterns.Behavioural.StateMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VendingUser {
    public static void main(String[] args){
        VendingWrapper user1 = new VendingWrapper();
        while (true){
            System.out.println("Press enter to goto next stage");
            getLine();
            user1.pull();
            System.out.println("Total Money : " + user1.getMoneyTotal());
        }
    }
    static String getLine() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = in.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }
}
