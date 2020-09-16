import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.StringTokenizer;

public class CHFNSWAP {

    static long solve(long n){
        long res = (n * (n+1)) / 2;
        return res;
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int test = fs.nextInt();
        //int cnt = 1;
        Map<Long, Boolean> M = new HashMap<>();
        M.put(20L, true);
        M.put(119L, true);
        M.put(696L, true);
        M.put(4059L, true);
        M.put(23660L, true);
        M.put(137903L, true);
        M.put(803760L, true);
        M.put(4684659L, true);
        M.put(27304196L, true);
        M.put(159140519L, true);
        M.put(927538920L, true);
        while (test-- > 0){
            long n = fs.nextLong();
            //cnt++;
            long res = (n*(n+1L)*1L)/2L;

            if (res % 2 == 0) {
                long pos = -1;
                long sum = 0;

                long lo = 1L;
                long hi = n;
                while (lo <= hi) {
                    long mid = (lo + hi) / 2L;
                    sum = mid * (mid + 1L) * 1L;
                    long diff = (res - sum) / 2L;
                    if (diff > mid) {
                        pos = mid;
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }

                long ans = n - pos;
                if (n>=4) ans--;

                if (M.containsKey(n)) {

                    long res1 = 0L;

                    res1 += solve(n-ans) - solve(n-ans-ans);

                    res1 += solve(n-ans-ans-1L);

                    res1 += ((ans-1L)*ans*1L) / 2L;

                    ans = res1;
                }

                System.out.println(ans);


            } else {
                System.out.println(0);
            }

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

