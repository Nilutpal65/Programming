import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        ArrayList<Integer> ar = new ArrayList<>();
        String nn[] = br.readLine().split(" ");
        while (test-- > 0) {
            int n = Integer.parseInt(nn[test]);
            ar.add(n);
        }
        int n= ar.size();
        int dp[][] = new int[n+1][n+1];
        int isPalin[][] = new int[n+1][n+1];
        for (int i=0;i<n;++i) {
            dp[i][i]=1;
            isPalin[i][i]=1;
            if (i<n-1) {
                if (ar.get(i) == ar.get(i+1)) {
                    dp[i][i+1]=2;
                    isPalin[i][i+1]=1;
                }
            }
        }
        int sz=2;
        for (int i=0;i<n-2;++i) {
            for (int j=0;j<n-sz;++j) {
                // System.out.println(j + " " + (int)(j+sz));
                if(ar.get(j) == ar.get(j+sz)) {
                    if (isPalin[j+1][j+sz-1]==1) {
                        dp[j][j+sz] = 2 + dp[j+1][j+sz-1];
                        isPalin[j][j+sz] = 1;
                    } else {
                        dp[j][j+sz] = Math.max(dp[j+1][j+sz], dp[j][j+sz-1]);
                    }
                } else {
                    dp[j][j+sz] = Math.max(dp[j+1][j+sz], dp[j][j+sz-1]);
                }
            }
            ++sz;
        }
        System.out.println(dp[0][n-1]);
    }
}
