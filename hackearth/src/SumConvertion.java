import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumConvertion {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String in[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(in[0]);
            int k = Integer.parseInt(in[1]);
            int a[] = new int[n];
            in = br.readLine().trim().split(" ");
            for (int i=0;i<n;++i){
                a[i] = Integer.parseInt(in[i]);
            }
            boolean dp[][] = new boolean[n+1][20201];
            for (int i=0;i<n+1;++i){
                Arrays.fill(dp[i], false);
            }
            dp[0][10000 - a[0]] = true;
            dp[0][10000 + (a[0]+1)] = true;
            dp[0][10000 + (a[0]-1)] = true;
            dp[0][10000 + a[0]] = true;
            for (int i=1;i<n;++i){
                for (int j=0;j<20001;++j)
                    if (dp[i-1][j]){
                        dp[i][j-a[i]] = true;
                        dp[i][j+a[i]+i+1] = true;
                        dp[i][j+(a[i]-(i+1))] = true;
                        dp[0][j+a[i]] = true;
                    }
            }
            if (dp[n-1][k+10000]){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            //System.out.println(dp[n-1][k+10000]);
        }
    }
}
