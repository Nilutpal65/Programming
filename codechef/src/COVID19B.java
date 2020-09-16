import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class COVID19B {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int test = fs.nextInt();
        while (test-- > 0){
            int n = fs.nextInt();
            int a[] = new int[n];
            for (int i=0;i<n;++i) a[i] = fs.nextInt();
            int ans[] = new int[n];
            Arrays.fill(ans, 1);
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i=0;i<n;++i){
                int cnt  = 1;
                int mx = a[i];
                for (int j=0;j<i;++j) {
                    if (a[j]>a[i]){
                        cnt++;
                        mx = Math.max(a[j], mx);
                    }
                }
                for (int j=i+1;j<n;++j) {
                    if (a[j]<mx) cnt++;
                }
                //min = Math.min(ans[i], min);
                //System.out.println(i + " "  + cnt);
                max = Math.max(cnt, max);
                //min = Math.min(cnt, min);
            }
            for (int i =0; i<n;++i){
                int cnt = 1;
                int mx = a[i];
                int mega_mx = a[i];
                //left < a[i]
                for (int j=i+1;j<n;++j) if (a[i]>a[j]) {
                    cnt++;
                    mx = Math.min(mx, a[j]);
                }
                for (int j=0;j<i;++j) if (a[j]>mx) {
                    ++cnt;
                    mega_mx = Math.max(mega_mx, a[j]);
                }


                //right > a[i]
                for (int j=i+1;j<n;++j) {
                    if (a[j]>=a[i] && mega_mx>a[j]){
                        ++cnt;
                    }
                }

                min = Math.min(cnt, min);
            }
            System.out.println(min + " " + max);
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
