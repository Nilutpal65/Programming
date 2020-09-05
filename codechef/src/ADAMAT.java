import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ADAMAT {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int test = fs.nextInt();
        while (test-- > 0){
            int n = fs.nextInt();
            int a[][] = new int[n][n];
            for (int i=0;i<n;++i){
                for (int j=0;j<n;++j) a[i][j] = fs.nextInt();
            }
            List< List<Integer> >L = new ArrayList<>();
            for (int k=0;k<n;++k){
                int j = 0;
                int i = k;
                List<Integer>T = new ArrayList<>();
                while (i>=0){
                    T.add(a[i][j]);
                    --i; ++j;
                }
                if (T.size() % 2 == 1) {
                    T.remove(T.size()/2);
                }
                if (T.size() > 1){
                    L.add(T);
                }
            }

            for (int k=1;k<n;++k){
                int j = k;
                int i = n-1;
                List<Integer>T = new ArrayList<>();
                while (j<=n-1){
                    T.add(a[i][j]);
                    --i; ++j;
                }
                if (T.size() % 2 == 1) {
                    T.remove(T.size()/2);
                }
                if (T.size() > 1){
                    L.add(T);
                }
            }

            List<Boolean>B = new ArrayList<>();
            for (List<Integer> e:L){
                int first = e.get(0);
                int last = e.get(e.size()-1);
                if (first < last){
                    B.add(false);
                } else {
                    B.add(true);
                }
            }

            Collections.reverse(B);
            boolean not = true;
            int cnt = 0;
            for (Boolean e:B) {
                boolean cur = (not) ? e : !e;
                if (cur){
                    continue;
                } else {
                    cnt++;
                    not = !not;
                }
            }
            System.out.println(cnt);
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
