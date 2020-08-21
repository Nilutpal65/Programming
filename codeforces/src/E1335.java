import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E1335 {
    static int dp[][] = new int[2222][2222];
    static int count[][] = new int[2222][27];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test= Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            String in[] = br.readLine().trim().split(" ");
            int a[] = new int[n+1];

            int ans = 1;

            for (int i=1;i<=n;++i) {
                Arrays.fill(dp[i], 0);
                Arrays.fill(count[i], 0);
                a[i] = Integer.parseInt(in[i-1]);
                count[i][a[i]]++;
                for (int j=1;j<=26;++j) {
                    count[i][j] += count[i-1][j];
                }
                dp[i][i] = 1;
                if (i>1){
                    dp[i-1][i] = (a[i] == a[i-1]) ? 2 : 1;
                    ans = Math.max(dp[i-1][i], ans);
                }
            }

            //dp[j][j+sz] = (a[j] == a[j+sz]) ? (count[j+sz][a[j]] - count[j-1][a[j]]) : Math.max(dp[j+1][j+sz], dp[j][sz+j-1]);

            int sz = 2 ;



            for (int i=1;i<=n;++i) {
                for (int j=1;j<=n-sz;++j) {
                    if (a[j] == a[j+sz]) {
                        dp[j][j+sz] = count[j+sz][a[j]] - count[j-1][a[j]];
                    } else {
                        dp[j][j+sz] = Math.max(dp[j+1][j+sz], dp[j][j+sz-1]);
                    }
                    ans=  Math.max(ans, dp[j][j+sz]);
                }
                sz++;
            }


//            for (int i=1;i<=n;++i) {
//                for (int j=1;j<=n;++j){
//                    System.out.print(dp[i][j] + " " );
//                }
//                System.out.println("");
//            }

            for (int i=1;i<=n;++i) {
                for (int j=i+2;j<=n;++j) {
                    if (a[i] == a[j]) {
                        ans = Math.max(ans, (Math.min( count[i][a[i]] ,  count[n][a[i]] - count[j-1][a[i]]) * 2) + dp[i+1][j-1]);
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
