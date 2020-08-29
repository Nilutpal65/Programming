import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E1400 {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int a[] = new int[n];
        for (int i=0;i<n;++i)a[i] = fs.nextInt();
        int i = 0;
        int res = 0;
        while (i<n) {
            int mn1 = a[i];
            int mn2 = a[i];
            int cnt = 0;
            while (i<n && a[i]>0) {
                if (a[i] > mn1) {
                    mn2 = mn1;
                    mn1 = a[i];
                }
                cnt++;
                ++i;
            }
            if (cnt == 1) {
                res += 1;
            } else {
                res += Math.min(mn2 + 1, cnt);
            }
            if (i<n && a[i] == 0) ++i;
        }
        System.out.println(res);
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
