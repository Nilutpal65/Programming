
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread_03_02 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i=0;i<10;++i) {
            Runnable worker = new WorkerThread("I'm a thread " + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) { }
        System.out.println("Finished all Threads");
    }
}
