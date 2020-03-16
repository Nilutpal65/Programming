public class Thread_02_02 {
    static int counter = 1;
    public static synchronized int getID() {
        return counter++;
    }
    public static void main(String[] args) {
        Runnable r1 = ()-> {
            System.out.println(getID());
        };
        Thread t1 = new Thread(r1, "t1");
        t1.start();
        Thread t2 = new Thread(r1, "t2");
        t2.start();
    }
}
