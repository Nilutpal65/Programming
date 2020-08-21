import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            String in[] = br.readLine().trim().split(" ");

            long a[] = new long[n];
            for (int i=0;i<n;++i){
                a[i] = Integer.parseInt(in[i]);
            }

            long suf[] = new long[n];
            suf[n-1] = a[n-1];
            for (int i=n-2; i>=0; --i){
                suf[i] = Math.max(suf[i+1], a[i]);
            }

            long pre[] = new long[n];
            pre[0] = a[0];
            for (int i=1;i<n;++i) {
                pre[i] = Math.min(pre[i-1], a[i]);
            }

            int i = 0;
            int j = 0;
            int ans = 0;

            while (i < n && j < n){
                if (pre[i] < suf[j]) {
                    ans = Math.max(j-i, ans);
                    ++j;
                } else {
                    ++i;
                }
            }
            System.out.println(ans);
        }
    }
}
