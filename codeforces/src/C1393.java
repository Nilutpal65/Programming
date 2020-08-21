import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C1393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            int a[] = new int[n];
            String in[] = br.readLine().trim().split(" ");
            Map<Integer, Integer>M = new HashMap<>();
            int mx = -1;
            for (int i=0;i<n;++i){
                a[i] = Integer.parseInt(in[i]);
                if (M.containsKey(a[i])){
                    M.put(a[i], M.get(a[i])+1);
                } else {
                    M.put(a[i], 1);
                }
                mx = Math.max(mx, M.get(a[i]));
            }

            //List<Integer>L = new ArrayList<>();
            int cnt = 0;
            for (int i=0;i<n;++i){
                if (M.get(a[i]) == mx){
                    cnt++;
                    M.put(a[i], 0);
                }
            }
            int ans = 0;
            if (cnt == 1){
                int res = n - mx;
                if (mx > 1){
                    ans = res / (mx - 1);
                }
            } else {
                int res = n - (mx * cnt);
                ans = cnt - 1;
                if (mx == 2){
                    ans += res;
                } else {
                    if (mx > 1){
                        ans += res / ( mx - 1);
                    }
                }
            }
            if (mx == 1) ans = 0;
            System.out.println(ans);
        }
    }
    // expected: '1', found: '2'
    //7
    //1 2 1 2 1 2 3
}
