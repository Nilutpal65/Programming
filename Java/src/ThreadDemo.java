public class ThreadDemo extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}
class MainDemo{
    public static void main(String[] args){
        for (int i=0;i<5;++i) {
            ThreadDemo t = new ThreadDemo();
            t.start();
        }
    }
}
