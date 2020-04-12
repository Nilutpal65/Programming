import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrangeBallsSuchNoAdjacentSame {
    static int dp[][][] = new int[11][11][11];
    public static int solve(int p, int q, int r,int cur){
        if (p==0 && q==0 && r==0){
            return 1;
        }
        if (p>=0 && q>=0 && r>=0) {
            if (cur == 0) {
                dp[p][q][r] = solve(p,q-1,r,1) + solve(p,q,r-1,2);
            } else if (cur == 1){
                dp[p][q][r] = solve(p-1,q,r,0) + solve(p,q,r-1,2);
            } else {
                dp[p][q][r] = solve(p,q-1,r,1) + solve(p-1,q,r,0);
            }
            return dp[p][q][r];
        }
        return 0;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String s[] = br.readLine().split(" ");
            int p = Integer.parseInt(s[0]);
            int q = Integer.parseInt(s[1]);
            int r = Integer.parseInt(s[2]);
            for(int i=0;i<p;++i) {
                for(int j=0;j<q;++j){
                    Arrays.fill(dp[i][j], 0);
                }
            }
            int ans = solve(p,q,r,0) + solve(p,q,r,1) + solve(p,q,r,2);
            ans /= 2;
            System.out.println(ans);
        }
    }
}
