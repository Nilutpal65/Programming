import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintNum implements Runnable{
    private int num;
    PrintNum(int num){
        this.num = num;
    }
    public void run(){
        System.out.println(num);
    }
}


class Test{
    private int num;
    void testNum(int num){
        this.num = num;
    }
    void printNum(){
        System.out.println(num);
    }

}

public class ThreadPoolExecutorDemo {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new PrintNum(3));
        executorService.shutdown();
    }
}
