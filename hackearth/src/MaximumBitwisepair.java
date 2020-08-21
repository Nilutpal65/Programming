import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumBitwisepair {
    static long dp[];

    static int rev(int x){
        for (int i=0;i<17;++i) {
            if ((x & (1<<i)) == 0) {
                x = x | (1<<i);
            } else {
                x = x & ~(1<<i);
            }
        }
        return x;
    }


    static long solve(int x, int n){
        if(dp[x] != -1) return dp[x];
        long res = 0;
        for (int i=0;i<17;++i) {
            if ((x & (1<<i)) != 0){
                int r = x & ~(1<<i);
                res = Math.max(solve(r, n), res);
            }
        }
        dp[x] = res;
        return dp[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            dp = new long[1<<17 + 1];
            Arrays.fill(dp, -1);
            int n = Integer.parseInt(br.readLine());
            String in[] = br.readLine().trim().split(" ");
            long a[] = new long[n+1];
            for (int i=1;i<=n;++i){
                a[i] = Long.parseLong(in[i-1]);
                dp[i] = a[i];
            }
            int q = Integer.parseInt(br.readLine());
            while(q-- > 0){
                int x  = Integer.parseInt(br.readLine());
                int rx = rev(x);
                long ans = solve(rx, n) + a[x];
                if (ans == a[x]) {
                    System.out.println("-1");
                } else {
                    System.out.println(ans);
                }
            }
        }
    }
}
