import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E1305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().trim().split(" ");

        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        int ans[] = new int[n+1];
        int cnt[] = new int[2*n+1];
        Arrays.fill(ans, 0);
        Arrays.fill(cnt, 0);

        int remain = m;
        int i = 0;
        for(i=0;i<n;++i){
            if (remain<=cnt[i+1]){
                break;
            }
            remain -= cnt[i+1];
            ans[i] = i+1;
            for (int j=0;j<i;++j){
                cnt[ ans[i]+ans[j] ]++;
            }
        }

        if (i==n){
            System.out.println(-1);
            return;
        }

        int x = i+1;
        while (remain != cnt[x]){
            ++x;
        }

        ans[i] = x;

        int maxSum = (i == 0) ? ans[i] : (ans[i-1] + ans[i]);
        int cur = maxSum + 1;
        for(int j = i+1; j < n; ++j) {
            ans[j] = cur;
            cur += 2 * (maxSum + 1);
        }

        for (int j=0;j<n;++j){
            System.out.print(ans[j] + " ");
        }
    }
}
