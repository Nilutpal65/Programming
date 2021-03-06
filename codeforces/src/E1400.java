import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E1400 {
    static long solve(int a[], int be, int en) {
        if (be>en) return 0;
        long mn = Integer.MAX_VALUE;
        int ind = 0;
        for (int i=be;i<=en;++i) {
            if (a[i] < mn) {
                mn = a[i];
                ind = i;
            }
        }
        if (mn != -1) {
            for (int i=be;i<=en;++i) a[i] -= mn;
        }
        return Math.min(en-be+1L, solve(a, be, ind-1) + solve(a, ind+1, en) + mn);
    }
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int a[] = new int[n];
        for (int i=0;i<n;++i)a[i] = fs.nextInt();
        System.out.println(solve(a, 0, n-1));
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
