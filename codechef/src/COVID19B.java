import javax.annotation.processing.SupportedSourceVersion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class COVID19B {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int test = fs.nextInt();
        while (test-- > 0){
            int n = fs.nextInt();
            int a[] = new int[n];
            for (int i=0;i<n;++i) a[i] = fs.nextInt();
            Map<Integer, Integer> M = new HashMap<>();
            for (int i=0;i<n;++i) {
                M.put(i, i+1);
            }

            for (int i=0;i<n;++i) {
                Map<Integer, Integer>mo = new HashMap<>();
                mo.put(i, 1);
                for (int j=1;j<=50;++j){
                    for (int k=0;k<n;++k){
                        mo.put(k, M.get(k)+a[k]);
                    }

                }
            }

//            List<Integer>L[] = new ArrayList[250];
//            for (int i=0;i<250;++i) L[i] = new ArrayList<>();
//            for (int i=0;i<50;++i) {
//                for (int j=0;j<n;++j) if (M.get(j)<250){
//                    L[M.get(j)].add(j);
//                    M.put(j, M.get(j) + a[j]);
//                }
//            }
//            for (int i=0;i<n;++i) {
//                Map<Integer, Boolean> mo = new HashMap<>();
//                mo.put(i, true);
//                for (int j=0;j<250;++j) if (L[j].size()>0) {
//                    if (L[j].contains(new Integer(i))){
//                        for (Integer e:L[j]){
//                            mo.put(e, true);
//                        }
//                    }
//                }
//                System.out.println(mo.size());
//            }
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
