import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

// https://codeforces.com/problemset/problem/1336/B
public class B1336 {
    static long ans = Long.MAX_VALUE;

    static void solve(int a[], int b[], int c[]){
        for (int i=0;i<a.length;++i){
            int lo1 = 0;
            int hi1 = b.length - 1;
            int res1 = 0;
            while (lo1<=hi1){
                int mid = (lo1 + hi1) / 2;
                if(b[mid]>=a[i]){
                    res1 = mid;
                    hi1 = mid-1;
                } else {
                    lo1 = mid+1;
                }
            }
            // System.out.println(res1);


            int lo2 = 0;
            int hi2 = c.length - 1;
            int res2 = 0;
            while (lo2<=hi2){
                int mid = (lo2 + hi2) / 2;
                if(c[mid]<=a[i]){
                    res2 = mid;
                    lo2 = mid+1;
                } else {
                    hi2 = mid-1;
                }
            }

            if(res1<b.length && res2<c.length && b[res1]>=a[i] && c[res2]<=a[i]){
                long u = a[i];
                long v = b[res1];
                long w = c[res2];
                //System.out.println(u + " " + v + " " + w);
                ans = Math.min(ans, multiply(u,v)+multiply(u,w)+multiply(w,v));
            }
        }
    }

    static long multiply(long a, long b){
        return (a-b)*(a-b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            ans = Long.MAX_VALUE;
            String in[] = br.readLine().trim().split(" ");
            int r = Integer.parseInt(in[0]);
            int g = Integer.parseInt(in[1]);
            int b = Integer.parseInt(in[2]);
            int ar[] = new int[r];
            int ag[] = new int[g];
            int ab[] = new int[b];

            in = br.readLine().trim().split(" ");
            for (int i=0;i<r;++i){
                ar[i] = Integer.parseInt(in[i]);
            }

            in = br.readLine().trim().split(" ");
            for (int i=0;i<g;++i){
                ag[i] = Integer.parseInt(in[i]);
            }

            in = br.readLine().trim().split(" ");
            for (int i=0;i<b;++i){
                ab[i] = Integer.parseInt(in[i]);
            }

            Arrays.sort(ar);
            Arrays.sort(ag);
            Arrays.sort(ab);

            solve(ar, ag, ab);
            solve(ar, ab, ag);
            solve(ag, ar, ab);
            solve(ag, ab, ar);
            solve(ab, ar, ag);
            solve(ab, ag, ar);

            System.out.println(ans);
        }
    }
}
