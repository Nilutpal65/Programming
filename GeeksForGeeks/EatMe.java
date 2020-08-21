import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EatMe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().trim().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);
        long mod = (long) 1e9+7;
        long dp[][] = new long[n+1][k+1];
        for (int i=1;i<=n;++i) dp[i][1]=n-i+1;
        for (int i=2;i<=k;++i){
            for (int j=1;j<=n;++j){
                dp[j][i] = dp[j][i-1];
            }
            for (int j=n-1;j>=1;--j){
                dp[j][i] += dp[j+1][i];
                if (dp[j][i] > mod){
                    dp[j][i] -= mod;
                }
            }
        }
        long ans = 0;
        for (int i=1;i<=k;++i){
            ans += dp[1][i];
            if (ans > mod){
                ans -= mod;
            }
        }
        System.out.println(ans);
    }
}


