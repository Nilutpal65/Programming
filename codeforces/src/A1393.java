import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            n = n/2 + 1;
            System.out.println(n);
        }
        //String in[] = br.readLine().trim().split(" ");
    }
}
