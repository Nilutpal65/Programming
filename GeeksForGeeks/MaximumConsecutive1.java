import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MaximumConsecutive1 {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int test = fs.nextInt();
        while (test-- > 0){
            int n = fs.nextInt();
            int a[] = new int[n];
            for (int i=0;i<n;++i){
                a[i] = fs.nextInt();
            }
            int m = fs.nextInt();
            int ans = 0;
            int zero = 0;
            int i = 0, j = 0;
            while (i < n){
                if (a[i] == 0) zero++;
                ++i;
                while (zero > m && j<=i) {
                    if (a[j] == 0) --zero;
                    ++j;
                }
                ans  = Math.max(i-j, ans);
            }
            System.out.println(ans);
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
