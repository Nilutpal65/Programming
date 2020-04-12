import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestZigZagSequence {
    static int dp[][] = new int[2][100005];

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            String in[] = br.readLine().split(" " );
            int a[] = new int[n+1];
            for (int i=0;i<n;++i) {
                a[i] = Integer.parseInt(in[i]);
            }
            Arrays.fill(dp[0], 0);
            Arrays.fill(dp[1], 0);
            int ans = 1;
            dp[0][0] = dp[1][0] = 1;
            for (int i=1;i<n;++i){
                for (int j=0;j<i;++j) {
                    if (a[j]>a[i]){
                        dp[1][i] = Math.max(dp[1][i], dp[0][j]+1);
                    }
                    if (a[j]<a[i]){
                        dp[0][i] = Math.max(dp[0][i], dp[1][j]+1);
                    }
                }
                ans = Math.max(ans, Math.max(dp[0][i], dp[1][i]));
            }
            System.out.println(ans);
        }
    }
}
