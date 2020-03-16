public class Threads_01_03 extends Thread {
    public static void main(String[] args)throws InterruptedException{
        TestJoinClass t1 = new TestJoinClass("t1");
        TestJoinClass t2 = new TestJoinClass("t2");
        TestJoinClass t3 = new TestJoinClass("t3");
        t1.start();
        try {
            t1.join();
        } catch (Exception e) {

        }
        t2.start();
        t3.start();
    }
}
