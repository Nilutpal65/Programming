import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LargestTimeforGivenDigits {
    static String largestTimeFromDigits(int[] A) {
        List<Integer> L = new ArrayList<>();
        for (int i=0;i<4;++i) L.add(A[i]);
        Collections.sort(L);
        String ans = "";
        for (int i=0;i<=2;++i) {
            for (int j=0;j<=9;++j) {
                List<Integer> T = new ArrayList<>(L);
                if (i==2 && j>=4) {
                    break;
                }
                String res = "";
                int f,s,t,fo;
                if (T.contains(i)) {
                    res += i;
                    T.remove(new Integer(i));

                }
                if (T.contains(j)) {
                    res += j;
                    T.remove(new Integer(j));
                }
                if (T.size() == 2) {
                    int res1 = -1;
                    if (T.get(0) >=0 && T.get(0) <= 5) {
                        res1 = 0;
                        res1 += (T.get(0) * 10) + T.get(1);
                    }
                    int res2 = -1;
                    if (T.get(1) >=0 && T.get(1) <= 5) {
                        res2 = 0;
                        res2 += (T.get(1) * 10) + T.get(0);
                    }
                    res1 = Math.max(res1, res2);
                    if (res1 != -1) {
                        res = res + ":";
                        if (res1<10) res += '0';
                        res += res1;
                    }
                }
                if (res.length() == 5) {
                    ans = res;
                }
            }
        }
        //System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) throws IOException {
        largestTimeFromDigits(new int[] {1,2,3,4});
        //FastScanner fs = new FastScanner();
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
