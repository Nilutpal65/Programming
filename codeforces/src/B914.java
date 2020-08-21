import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class B914 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String in[] = br.readLine().trim().split(" " );

        int mx = 0;
        int a[] = new int[n];
        Map<Integer, Integer>M = new HashMap<>();
        for (int i=0;i<n;++i) {
            int x = Integer.parseInt(in[i]);
            a[i] = x;
            if (x>mx) {
                mx = x;
            }
            int cnt = (M.containsKey(x)) ? M.get(x) : 0;
            M.put(x, cnt+1);
        }
        int cnt = 0;
        // System.out.println(mx + " " + res);
        for (int i=0;i<n;++i) {
            if (M.get(a[i]) % 2 == 0) {
                cnt++;
            }
        }
        if (cnt == n) {
            System.out.println("Agasa");
        } else {
            System.out.println("Conan");
        }
    }
}
