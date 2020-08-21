import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            String in[] = br.readLine().split(" ");
            in = br.readLine().split(" ");
            int n = in[0].length();
            int m = in[1].length();
            int dp[][] = new int[n+1][m+1];
            for (int i=0;i<=n;++i) {
                for (int j=0;j<=m;++j) {
                    if (i==0) {
                        if (j>0) {
                            dp[i][j]+=dp[i][j-1]+1;
                        }
                    } else if (j==0){
                        if (i>0){
                            dp[i][j]+=dp[i-1][j]+1;
                        }
                    } else {
                        if (in[0].charAt(i-1) == in[1].charAt(j-1)) {
                            dp[i][j] = dp[i-1][j-1];
                        } else {
                            dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                        }
                    }
                    //System.out.print(dp[i][j] + " ");
                }
                //System.out.println(" ");
            }
            System.out.println(dp[n][m]);
        }
    }
}
