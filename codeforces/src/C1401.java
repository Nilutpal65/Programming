import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C1401 {
    static List<Integer> []L;
    static int gcd(int a, int b){
        if (b == 0) return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            L = new ArrayList[100005];
            int n = Integer.parseInt(br.readLine());
            int a[] = new int[n];
            int b[] = new int[n];
            String in[] = br.readLine().trim().split(" ");
            int cnt = 1;
            Map<Integer, Integer> M = new HashMap<>();
            int mn  =Integer.MAX_VALUE;
            for (int i=0;i<n+1;++i){
                L[i] = new ArrayList<>();
            }
            for (int i=0; i<n; ++i) {
                a[i] = Integer.parseInt(in[i]);
                b[i] = a[i];
                if (!M.containsKey(a[i])){
                    M.put(a[i], cnt);
                    cnt++;
                }
                L[M.get(a[i])].add(i);
                mn = Math.min(mn, a[i]);
            }
            Arrays.sort(b);
            boolean flag = true;
            for (int i=0;i<n;++i) {
                if (a[i] != b[i]) {
                    if (a[i] % mn != 0) {
                        flag = false;
                        break;
                    }
                }
            }

//            boolean flag = true;
//            for (int i=0;i<n;++i){
//                boolean got = false;
//                if (a[i] != b[i]){
//                    if (gcd(a[i], b[i]) != mn){
//                        flag = false;
//                        break;
//                    }
//                    Integer ind = -1;
//                    for (Integer e:L[M.get(b[i])]){
//                        ind = e;
//                        break;
//                    }
//                    if (ind != -1) {
//                        L[M.get(b[i])].remove(ind);
//                        Integer cur = i;
//                        L[M.get(a[i])].remove(cur);
//                        L[M.get(a[i])].add(ind);
//                        got = true;
//                    }
//                } else {
//                    Integer cur = i;
//                    L[M.get(a[i])].remove(cur);
//                    got = true;
//                }
//                if (!got) {
//                    flag = false;
//                    break;
//                }
//            }



            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
