import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LCSSpaceOptimised {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0){
            String in[] = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            int m = Integer.parseInt(in[1]);
            String n1 = br.readLine();
            String n2 = br.readLine();

            int dp[][] = new int[2][200];
            Arrays.fill(dp[0], 0);
            Arrays.fill(dp[1], 0);
            int bit = 0;
            for (int i=0;i<=n;++i){
                bit = i&1;
                for (int j=0;j<=m;++j) {
                    if (i==0 || j==0) dp[bit][j]=0;
                    else if (n1.charAt(i-1) == n2.charAt(j-1)) dp[bit][j] = 1+dp[1-bit][j-1];
                    else dp[bit][j] = Math.max(dp[bit][j-1], dp[1-bit][j]);
                }
            }
            System.out.println(dp[bit][m]);
        }
    }
}