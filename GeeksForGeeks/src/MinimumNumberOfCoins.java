import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinimumNumberOfCoins {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0){
            String in[] = br.readLine().split(" " );
            int v = Integer.parseInt(in[0]);
            int n = Integer.parseInt(in[1]);
            in = br.readLine().split(" ");
            int dp[] = new int[v+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            int arr[] = new int[n+1];
            for (int i=0;i<n;++i) {
                arr[i] = Integer.parseInt(in[i]);
            }
            dp[0]=0;
            for (int i=0;i<=v;++i) {
                for (int j=0;j<n;++j) {
                    if (i>=arr[j]){
                        if (dp[i-arr[j]]!=Integer.MAX_VALUE) {
                            dp[i] = Math.min(dp[i], dp[i-arr[j]]+1);
                        }
                    }
                }
            }
            if (dp[v] == Integer.MAX_VALUE) dp[v]=-1;
            System.out.println(dp[v]);
        }
    }
}
