import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class MinimumTwoSubsets {
    static int dp[][] = new int[51][2555];
    public static int recur(int sum, int ind, int a[], int tot){
        if (dp[ind][sum]!=-1){
            return dp[ind][sum];
        }
        if (ind == 0) {
            return Math.abs(tot-sum-sum);
        }
        dp[ind][sum] = Math.min(recur(sum+a[ind-1], ind-1,a,tot), recur(sum, ind-1,a,tot));
        return dp[ind][sum];
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){

            int n = Integer.parseInt(br.readLine());
            String st[] = (br.readLine()).split(" ");
            int a[] = new int[n+1];
            int tot = 0;
            for (int i=0;i<n;++i) {
                a[i] = Integer.parseInt(st[i]);
                tot += a[i];
                Arrays.fill(dp[i],-1);
            };
            Arrays.fill(dp[n], -1);
            int ans = recur(0,n,a,tot);
            System.out.println(ans);
        }
    }
}
