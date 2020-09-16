import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class EQDIV {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int k = fs.nextInt();
        int test = fs.nextInt();
        while (test-- > 0){
            long n = fs.nextLong();
            long res = n % 4;
            if (res == 0 || res == 3) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
            long sum = (n * (n + 1L) * 1L) / 2L;
            sum = sum / 2L;
            int ans[] = new int[(int)n+1];


            long lo = 0;
            long hi = n;
            long pos = 0;
            while (lo<=hi){
                long mid = (lo + hi)/2;
                long res1 = (mid * (mid+1))/2;
                if (res1<=sum) {
                    pos = mid;
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            }



            for (int i=1;i<=(int)n;++i){
                System.out.print(ans[i]);
            }
            System.out.println("");
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
