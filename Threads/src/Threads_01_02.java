public class Threads_01_02 {
    public static void main(String[] args) {
        (new Thread(new HelloRunnable())).start();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from " + Thread.currentThread().getName());
            }
        };

        Runnable r2 = () ->  System.out.println("Hello from " + Thread.currentThread().getName());

        Thread t1 = new Thread(r1, "Thread t1");
        t1.start();

        Thread t2 = new Thread(r2);
        t2.start();
    }
}
