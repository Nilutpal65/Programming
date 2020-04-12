import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class CallableExample implements Callable{
    public Object call()throws Exception{
        Random number = new Random();
        Integer randomNumber = number.nextInt(5);
        Thread.sleep(1000*randomNumber);
        return randomNumber;
    }
}
public class CallableFutureTest {
    public static void main(String[] args)throws Exception{
        FutureTask[] randomTask = new FutureTask[5];
        for (int i=0;i<5;++i){
            Callable call = new CallableExample();
            randomTask[i] = new FutureTask(call);
            Thread t = new Thread(randomTask[i]);
            t.start();
        }
        for (int i=0;i<5;++i){
            System.out.println(randomTask[i].get());
        }
    }
}
