import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D1400 {
    public static void main(String[] args) throws IOException {
        FastScanner fs =  new FastScanner();
        int test = fs.nextInt();
        while (test-- > 0) {
            int n = fs.nextInt();
            int a[] = new int[n];
            List<Integer>L = new ArrayList<>();
            for (int i=0;i<n;++i) {
                a[i] = fs.nextInt();
                if (!L.contains(a[i])) {
                    L.add(a[i]);
                }
            }
            int dp[][]  = new int[n+1][3050];
            int dp2[][]  = new int[n+1][3050];
            for (int i=n-1;i>=0;--i) {
                dp[i][a[i]]++;
                if (i + 1 < n) {
                    for (int j=0;j<L.size();++j) {
                        dp[i][L.get(j)] += dp[i+1][L.get(j)];
                    }
                }
            }
            for (int i=0;i<n;++i) {
                dp2[i][a[i]]++;
                if (i > 0) {
                    for (int j=0;j<L.size();++j) {
                        dp2[i][L.get(j)] += dp2[i-1][L.get(j)];
                    }
                }
            }
            long ans = 0;

            for (int i=1;i<n;++i) {
                for (int j=i+1;j<n;++j) {
                    if (a[i] != a[j]) {
                        ans += dp2[i][a[j]] * dp[j][a[i]];
                    }
                }
            }
            for (Integer e:L) {
                if (dp2[n-1][e] > 3) {
                    long res = dp2[n-1][e];
                    res = (res * (res - 1L) * (res - 2L) * (res - 3L) * 1L) / 24L;
                    ans += res;
                }
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
