import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestIncreasingPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String in[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(in[0]);
            int m = Integer.parseInt(in[1]);
            int a[][] = new int[n][m];
            int dp[][] = new int[n][m];
            for (int i=0;i<n;++i){
                in = br.readLine().trim().split(" ");
                for (int j=0;j<m;++j){
                    a[i][j] = Integer.parseInt(in[j]);
                }
                Arrays.fill(dp[i], 1);
            }

            for (int i=m-2;i>=0;--i){
                if (a[n-1][i] < a[n-1][i+1]){
                    dp[n-1][i] += dp[n-1][i+1];
                }
            }
            for (int i = n-2; i>=0; --i){
                if (a[i][m-1] < a[i+1][m-1]){
                    dp[i][m-1] += dp[i+1][m-1];
                }
            }

            int ans = 1;

            for (int i=n-2;i>=0;--i){
                for (int j=m-2;j>=0;--j){
                    int cnt = 0;
                    if (a[i][j]<a[i+1][j]) cnt = dp[i+1][j];
                    if (a[i][j]<a[i][j+1]) cnt = Math.max(cnt, dp[i][j+1]);
                    dp[i][j] += cnt;
                    ans = Math.max(dp[i][j], ans);
                }
            }

            System.out.println(dp[0][0]);
        }
    }
}
