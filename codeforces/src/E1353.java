import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E1353 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String in[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(in[0]);
            int k = Integer.parseInt(in[1]);
            String s = br.readLine();

            long psum[] = new long[s.length()];
            Arrays.fill(psum, 0);
            psum[0] = ((s.charAt(0) == '1') ? 1L : 0L);
            for (int i=1; i< s.length(); ++i){
                psum[i] += psum[i-1] + ((s.charAt(i) == '1') ? 1L : 0L);
            }

            long dp[] = new long[s.length()];
            Arrays.fill(dp, 0);
            long ans = Math.max(0, psum[n-1] - 1);

            for (int i=0; i<k; ++i){
                dp[i] = psum[i] - ((s.charAt(i) == '1') ? 1L : 0L);
            }
            for (int i=k;i<n;++i){
                dp[i] = ((s.charAt(i) == '1') ? 0L : 1L) + Math.min(dp[i], dp[i-k] + (psum[i] - psum[i - k] - ((s.charAt(i) == '1') ? 1L : 0L)));
                ans = Math.min (ans, dp[i] + (psum[n-1] - psum[i]));
            }
            System.out.println(ans);
        }
    }
}

