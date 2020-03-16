public class WaitAndNotify {

    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();
        synchronized (b) {
            try {
                System.out.println("Waiting for thread ....");
                b.wait();
            } catch (Exception e) {

            }
            System.out.println(b.total);
        }
    }

    static class ThreadB extends Thread{
        int total ;
        public void run() {
            synchronized (this) {
                for (int i=0;i<10;++i) {
                    total+=i;
                }
                notify();
            }
        }
    }

}
