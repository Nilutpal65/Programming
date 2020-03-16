public class Thread_02_01 {
    static double a = 10;
    static double b;
    public static void main(String[] args) {
        Runnable r1 = ()-> {
            if (a == 10) {
                try {
                    Thread.sleep(10);
                    b = a/2;
                    System.out.println(b);
                } catch (Exception e) {

                }
            }
        };
        Runnable r2 = ()-> {
            a = 12;
        };
        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r2, "t2");
        t1.start();
        t2.start();

    }
}
