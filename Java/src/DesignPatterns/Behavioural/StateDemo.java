package DesignPatterns.Behavioural;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface State{
    void pull(CeilingFanPull wrapper);
}
class CeilingFanPull{
    private State state;
    CeilingFanPull(){
        state = new Off();
    }
    void setState(State state){
        this.state = state;
    }
    void pull(){
        state.pull(this);
    }
}
class Off implements State{
    public void pull(CeilingFanPull wrapper){
        wrapper.setState(new Low());
        System.out.println("Low Speed!");
    }
}
class Low implements State{
    public void pull(CeilingFanPull wrapper){
        wrapper.setState(new Medium());
        System.out.println("Medium Speed!");
    }
}
class Medium implements State{
    public void pull(CeilingFanPull wrapper){
        wrapper.setState(new High());
        System.out.println("High Speed!");
    }
}
class High implements State{
    public void pull(CeilingFanPull wrapper){
        wrapper.setState(new Off());
        System.out.println("Off!");
    }
}
public class StateDemo {
    public static void main(String[] args) {
        CeilingFanPull chain = new CeilingFanPull();
        while (true) {
            System.out.print("Press ENTER");
            getLine();
            chain.pull();
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
