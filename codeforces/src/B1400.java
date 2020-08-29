import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1400 {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int test = fs.nextInt();
        while (test-- > 0){
            long p = fs.nextLong(), f = fs.nextLong(), cnts = fs.nextLong(), cntw = fs.nextLong(), s = fs.nextLong(), w = fs.nextLong();

            if (s > w) {
                long temps = s;
                s = w;
                w = temps;

                temps = cnts;
                cnts = cntw;
                cntw = temps;
            }
            long ans = 0;
            for (int s1=0;s1<=Math.min(cnts, p / s);++s1){
                long w1 = Math.min(cntw, (p - (s1*s)) / w);
                long s2 = Math.min(cnts - s1, f / s);
                long w2 = Math.min(cntw - w1, (f - (s * s2)) / w);
                ans = Math.max(ans, s1 + w1 + s2 + w2);
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
