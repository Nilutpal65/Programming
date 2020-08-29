import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C1400 {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int test = fs.nextInt();
        while (test-- > 0){
            String s = fs.next();
            int n = s.length();
            int x = fs.nextInt();
            int a[] = new int[n];
            Arrays.fill(a, 1);
            for (int i=0;i<n;++i){
                if (s.charAt(i) == '0'){
                    if (i + x < n) a[i+x] = 0;
                    if (i - x >= 0) a[i-x] = 0;
                }
            }
            String ans = "", res="";
            boolean foo = true;
            for (int i=0;i<n;++i){
                boolean res1=false,res2=false;
                if (i + x < n && a[i+x] == 1) res1=true;
                if (i - x >= 0 && a[i-x] == 1) res2=true;
                if (res1 || res2) {
                    if (s.charAt(i) == '0') {
                        foo = false; break;
                    }
                }
                else {
                    if (s.charAt(i) == '1') {
                        foo = false; break;
                    }
                }
                res += a[i];
            }
            if (foo){
                System.out.println(res);
            } else {
                System.out.println(-1);
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
