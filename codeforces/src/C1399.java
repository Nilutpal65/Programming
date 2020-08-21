import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class C1399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            String in[] = br.readLine().trim().split(" ");
            int a[] = new int[n];
            Map<Integer, Integer> M = new HashMap<>();
            for (int i=0;i<n;++i) {
                a[i] = Integer.parseInt(in[i]);
                int res = 0;
                if (M.containsKey(a[i])) {
                    res = M.get(a[i]);
                }
                M.put(a[i], res+1);
            }
            Map<Integer, Integer>T = new HashMap<>();
            int ans = 0;
            for (int i=2;i<=100;++i){
                int cnt = 0;
                T = new HashMap<>(M);
                for (int j=0;j<n;++j){
                    if (T.containsKey(i - a[j])) {
                        if ((i - a[j]) == a[j]) {
                            int ob1 = T.get(a[j]) / 2;
                            cnt += ob1;
                            int t = T.get(a[j]) % 2;
                            T.put(a[j], t);
                        } else {
                            int ob1 = T.get(i - a[j]);
                            int ob2 = T.get(a[j]);
                            int mn = Math.min(ob1, ob2);
                            cnt += mn;
                            T.put(i-a[j], ob1-mn);
                            T.put(a[j], ob2-mn);
                        }
                    }
                }
                ans = Math.max(ans, cnt);
            }
            System.out.println(ans);
        }
    }
}
