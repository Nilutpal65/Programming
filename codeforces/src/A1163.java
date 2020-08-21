import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class A1163 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().trim().split(" " );
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        if (m == 0) {
            System.out.println(1);
        } else {
            System.out.println(Math.min(m, n - m));
        }
    }
}
