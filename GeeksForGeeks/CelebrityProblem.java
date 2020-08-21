import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CelebrityProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String in[] = br.readLine().trim().split(" ");
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            String in[] = br.readLine().trim().split(" ");
            int dp[][] = new int[n][n];
            int i=0,j=0;
            int cnt = 0;
            while (i+j != (2*n)) {
                i %= n;
                j %= n;

                dp[i][j] = Integer.parseInt(in[cnt++]);

                ++j;
                if (j==n) ++i;
            }

            int ans[] = new int[n];
            i =0;
            j=n-1;
            while (i<n && j>=0 && i<j){
                if (dp[i][j] == 1){
                  ++i;
                } else if (dp[j][i] == 1){
                    --j;
                } else {
                    ++i;
                    --j;
                }
            }
            boolean celebrity = true;
            for (int k=0;k<n-1;++k) {
                if (dp[i][k] == 1) {
                    celebrity = false;
                    break;
                }
            }
            if (celebrity) {
                System.out.println(i);
            } else {
                System.out.println("-1");
            }

//            for (i=0;i<n;++i) {
//                for (j=0;j<n;++j) {
//                    System.out.print(dp[i][j] + " ");
//                }
//                System.out.println("");
//            }
        }
    }
}
