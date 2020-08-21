import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetSum {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String in[] = br.readLine().trim().split(" ");
            int a[] = new int[n];
            int sum = 0;
            for (int i=0;i<n;++i) {
                a[i] = Integer.parseInt(in[i]);
                sum += a[i];
            }
            if ((sum & 1) == 1){
                System.out.println("NO");
                continue;
            }
            sum >>= 1;


            boolean dp[][] = new boolean[sum+1][n+1];
            for (int i=0;i<=n;++i) dp[0][i] = true;
            for (int i=0;i<=sum;++i) dp[i][0] = false;

            for (int i = 1; i <= sum; i++)
            {
                for (int j = 1; j <= n; j++)
                {
                    dp[i][j] = dp[i][j - 1];
                    if (i >= a[j - 1])
                        dp[i][j] = dp[i][j] ||
                                dp[i - a[j - 1]][j - 1];
                }
            }

            if (dp[sum][n]){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
