import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShortestCommonSupersequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String in[] = br.readLine().split(" ");
            String u = in[0];
            String v=  in[1];

            int n = u.length();
            int m = v.length();

            int dp[][] = new int[n+1][m+1];

            for (int i=1;i<=n;++i) {
                for (int j = 1;j<=m;++j) {
                    if (u.charAt(i-1) == v.charAt(j-1)){
                        dp[i][j] = Math.max(dp[i][j], 1 + dp[i-1][j-1]);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
                    }
                }
            }
            System.out.println(n+m-dp[n][m]);
        }
    }
}
