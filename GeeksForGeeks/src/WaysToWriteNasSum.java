import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WaysToWriteNasSum {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long mod = 1000000007;
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            long dp[] = new long[n+1];
            Arrays.fill(dp, 0);
            dp[0]=1;
            for (int i=1;i<n;++i) {
                for (int j=1;j<=n;++j){
                    if (j-i>=0) {
                        dp[j]+=dp[j-i];
                        if (dp[j]>mod) dp[j]-=mod;
                    }
                }
            }
            System.out.println(dp[n]);
        }
    }
}
