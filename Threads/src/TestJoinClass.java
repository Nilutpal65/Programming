public class TestJoinClass extends Thread {
    TestJoinClass(String name) {
        super(name);
    }
    public void run(){
        for (int i=0;i<5;++i) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + " i = " + i);
        }
    }
}
