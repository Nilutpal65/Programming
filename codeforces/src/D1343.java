import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class D1343 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String in[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(in[0]);
            int k = Integer.parseInt(in[1]);
            in = br.readLine().trim().split(" " );
            int a[] = new int[n];
            int diff = (n/2) - 1;
            Set<Integer> s = new HashSet<>();
            for (int i=0;i<n;++i) {
                a[i] = Integer.parseInt(in[i]);
                if (i > ((n/2)-1)) {
                    s.add(a[i]+a[diff]);
                    System.out.println(a[i]+a[diff]);
                    --diff;
                }
                System.out.println("");
            }
            System.out.println("-----");
        }
    }
}
