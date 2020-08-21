import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C1336 {
    static long dp[][] = new long[3001][3001]; //no. of ways to choose first i+1 elements of S such that they match with T[j]...T[j+i];

    static long modPower(long base, long power, long mod){
        long ans = 1L;
        base %= mod;
        while (power > 0L){
            if (power % 2L == 1L){
                ans *= base;
                ans %= mod;
            }
            base *= base;
            base %= mod;
            power /= 2L;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String in[] = br.readLine().trim().split(" ");
        String S = br.readLine();
        String T = br.readLine();

        int n = S.length();
        int m = T.length();

        for (int i=0;i<m;++i){
            if (S.charAt(0) == T.charAt(i)){
                dp[0][i] = 2;
            }
        }

        for (int i=1;i<n;++i){
            for (int j = 0;j<m;++j){
                if (S.charAt(i) == T.charAt(j)){
                    if (j == T.length()-1){
                        dp[i][j] += modPower(2L, i, 998244353L);
                    } else {
                        dp[i][j] = dp[i-1][j+1];
                    }
                }
                if(i+j>=m || (S.charAt(i) == T.charAt(i+j))){
                    dp[i][j]+=dp[i-1][j];
                }
                if (dp[i][j] > 998244353L){
                    dp[i][j] -= 998244353L;
                }
            }
        }
        long ans = 0L;
        for (int i=m-1; i<n; ++i){
            ans += dp[i][0];
            if (ans > 998244353L){
                ans -= 998244353L;
            }
        }
        System.out.println(ans);
    }
}
