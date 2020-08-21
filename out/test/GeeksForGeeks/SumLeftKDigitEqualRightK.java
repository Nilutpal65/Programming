import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumLeftKDigitEqualRightK {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String ar[] = (br.readLine()).split(" ");
        int a[] = new int[n+1];
        int dp[][] = new int[n+1][n+1];
        for (int i=0;i<n;++i) {
            a[i] = Integer.parseInt(ar[i]);
            dp[i][i] = a[i];
            if (i > 0) {
                dp[i-1][i] = a[i-1] + a[i];
            }
        }
        int sz = 2 ;
        for (int i=0;i<n;++i) {
            for (int j=0;j<n-sz;++j) {
                dp[j][j+sz] = a[j] + a[j+sz] + dp[j+1][j+sz-1];
            }
            ++sz;
        }
        int ans = 0;

    }
}
