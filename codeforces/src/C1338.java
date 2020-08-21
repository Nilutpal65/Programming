import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class C1338 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            long n =  Long.parseLong(br.readLine());

            long k = (n - 1) / 3;
            long D = 0;
            while (1<<(D<<1) <= k){
                k -= 1<<(D<<1);
                ++D;
            }

            k += (1<<(D<<1));
            long q = k;

            long w = 0;
            long e = 0;

            for (long h=0;h<=(D<<1);h+=2){
                if (k%4==1) { w+=(2L<<h); e+=(3L<<h); }
                if (k%4==2) { w+=(3L<<h); e+=(1L<<h); }
                if (k%4==3) { w+=(1L<<h); e+=(2L<<h); }
                k /= 4;
            }
            long a[] = new long[]{q, w, e};
            n = (n-1)%3;
            System.out.println(a[(int)n]);
        }
    }
}
