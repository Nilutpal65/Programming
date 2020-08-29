import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1400 {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int test = fs.nextInt();
        while (test-- > 0){
            int n = fs.nextInt();
            String s = fs.next();

            char c = s.charAt(n-1);
            String ans = "";
            for (int i=0;i<n;++i){
                ans += c;
            }

//            boolean hasOne = false;
//            for (int i=0;i<s.length();++i){
//                if (s.charAt(i) == '1') {
//                    hasOne = true;
//                    break;
//                }
//            }
//            String ans = "";
//            if (n == 1) {
//                if (hasOne) {
//                    ans = "1";
//                } else {
//                    ans = "0";
//                }
//            } else {
//                boolean foo = false;
//                if (s.charAt(0) == '1') {
//                    foo = true;
//                    ans = "10";
//                } else {
//                    ans = "01";
//                }
//
//                n -= 2;
//                for (int i=0;i<n;++i){
//                    ans += (foo) ? "1" : "0";
//                }
//            }
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
