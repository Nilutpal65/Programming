import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D118 {
    static long dp[][][][] = new long[111][111][11][11];
    static int n1, n2, k1, k2;
    static long mod = 100000000;
    static long solve(int nn1, int nn2, int kk1, int kk2){
        if (dp[nn1][nn2][kk1][kk2]!=-1){
            return (dp[nn1][nn2][kk1][kk2] % mod);
        }
        if (nn1+nn2 == 0){
            return dp[nn1][nn2][kk1][kk2] = 1;
        } else {
            long ans = 0;
            if (nn1>0 && kk1>0) ans += solve(nn1-1, nn2, kk1-1, k2) % mod;
            if (nn2>0 && kk2>0) ans += solve(nn1, nn2-1, k1, kk2-1) % mod;
            dp[nn1][nn2][kk1][kk2] = ans;
            return (dp[nn1][nn2][kk1][kk2] % mod);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().trim().split(" ");
        n1 = Integer.parseInt(in[0]);
        n2 = Integer.parseInt(in[1]);
        k1 = Integer.parseInt(in[2]);
        k2 = Integer.parseInt(in[3]);

        for (int i=0;i<111;++i){
            for (int j=0;j<111;++j){
                for (int k=0;k<11;++k){
                    for (int l=0;l<11;++l){
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }

        System.out.println(solve(n1, n2, k1, k2));

    }
}
