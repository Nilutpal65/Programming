import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelpHim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[][] = new int[n][n];
        int dp[][] = new int[n][n];
        int dp2[][] = new int[n][n];
        for (int i=0;i<n;++i){
            String in[] = br.readLine().trim().split(" ");
            for (int j=0;j<n;++j){
                a[i][j] = Integer.parseInt(in[j]);
                dp[i][j] = a[i][j];
                dp2[i][j] = a[i][j];
            }
        }
        for (int i=1;i<n;++i){
            dp[i][0] += dp[i-1][0];
            dp[0][i] += dp[0][i-1];
        }
        for (int i=1;i<n;++i){
            for (int j=1;j<n;++j){
                dp[i][j] += Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        for (int i=n-2;i>=0;--i){
            dp2[i][n-1] += dp2[i+1][n-1];
            dp2[n-1][i] += dp2[n-1][i+1];
        }

        for (int i=n-2;i>=0;--i){
            for (int j=n-2;j>=0;--j){
                dp2[i][j] += Math.min(dp2[i+1][j], dp2[i][j+1]);
            }
        }
        System.out.println(dp[n-1][n-1] + " " + dp2[0][0]);
    }
}
