package DesignPatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Observer{
    protected Subject subject;
    public abstract void update();
}
class Subject{
    private List<Observer>obs = new ArrayList<>();
    private int state;

    public void setState(int state){
        this.state = state;
        execute();
    }

    public void add(Observer o){
        obs.add(o);
    }
    public void remove(Observer o){
        obs.remove(o);
    }
    private void execute(){
        for (Observer o:obs){
            o.update();
        }
    }
}
class MathObserver extends Observer{
    public MathObserver(Subject s){
        this.subject = s;
        this.subject.add(this);
    }
    public void update(){
        System.out.println("Math !");
    }
}
class ScienceObserver extends Observer{
    public ScienceObserver(Subject s){
        this.subject = s;
        this.subject.add(this);
    }
    public void update(){
        System.out.println("Science !");
    }
}
public class ObserverDemo {
    public static void main(String[] args){
        Subject s = new Subject();
        Observer o1 = new MathObserver(s);
        Observer o2 = new ScienceObserver(s);
        o1.subject.remove(o1);
        Scanner sc = new Scanner(System.in);
        for (int i=0;i<5;++i){
            System.out.println("Enter a number : ");
            s.setState(sc.nextInt());
        }
    }
}
