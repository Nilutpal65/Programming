import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximiseSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String in[] = br.readLine().trim().split(" ");
        long a[] = new long[n+1];
        for (int i=0;i<n;++i){
            a[i] = Long.parseLong(in[i]);
        }
        long dp[][] = new long[2][n+1];
        for (int i=0;i<2;++i){
            Arrays.fill(dp[i], 0);
        }

        dp[0][0] = a[0];
        dp[1][0] = a[0];

        if (n>0){
            dp[0][1] = a[0]+a[1];
            dp[1][1] = a[0]*a[1]*1L;
        }

        for (int i=2;i<n;++i){
            dp[0][i] = a[i] + Math.max(dp[0][i-1], dp[1][i-1]);
            dp[1][i] = (a[i]*a[i-1]*1L) + Math.max(dp[0][i-2], dp[1][i-2]);
        }

//        for (int i=0;i<n;++i){
//            dp[i][i] = a[i];
//        }
//        for (int i=0;i<n-1;++i){
//            dp[i][i+1] = Math.max(a[i]+a[i+1], a[i]*a[i+1]);
//        }
//        int sz = 2;
//        for (int i=0;i<n-2;++i){
//            for (int j=0;j<n-sz;++j){
//                dp[j][j+sz] = Math.max(dp[j][j+sz], a[j]*dp[j+1][j+sz]);
//                dp[j][j+sz] = Math.max(dp[j][j+sz], a[j]+dp[j+1][j+sz]);
//                dp[j][j+sz] = Math.max(dp[j][j+sz], a[j+sz]*dp[j][j+sz-1]);
//                dp[j][j+sz] = Math.max(dp[j][j+sz], a[j+sz]+dp[j][j+sz-1]);
//            }
//            sz++;
//        }

//        for (int i=0;i<n;++i){
//            for (int j=0;j<n;++j){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println("");
//        }

        System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));

    }
}
