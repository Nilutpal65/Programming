import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){

            String in[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(in[0]);
            int k = Integer.parseInt(in[1]);
            int a[] = new int[n];
            int b[] = new int[n];

            in = br.readLine().trim().split(" ");
            for (int i=0;i<n;++i){
                a[i] = Integer.parseInt(in[i]);
            }

            in = br.readLine().trim().split(" ");
            for (int i=0;i<n;++i){
                b[i] = Integer.parseInt(in[i]);
            }
            Arrays.sort(a);
            Arrays.sort(b);

            long ans = 0;

            int end = n-1;
            for (int i=0;i<n;++i){
                if (a[i]<b[end] && (k-- > 0)){
                    a[i] = b[end--];
                }
                ans += a[i];
            }

            System.out.println(ans);

        }
    }
}
