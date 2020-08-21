import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class C1332 {
    /**
     * http://codeforces.com/problemset/problem/1332/C
     * @param args
     */
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String in[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(in[0]);
            int k = Integer.parseInt(in[1]);
            String s = br.readLine();
            int fre[] = new int[26];
            Arrays.fill(fre, 0);
            int ans = 0;


            if (k%2 == 1){
                int temp_k = k/2;
                int mx = 0;
                int tot = 0;
                while(temp_k<n){
                    fre[s.charAt(temp_k)-'a']++;
                    tot++;
                    mx = Math.max(mx, fre[s.charAt(temp_k)-'a']);
                    temp_k+=k;
                }
                ans += tot-mx;
            }


            int lo = 0 ;
            int hi = k-1;

            while (lo<hi){
                Arrays.fill(fre, 0);

                for(int i=lo;i<n;i+=k){
                    fre[s.charAt(i)-'a']++;
                }
                for(int i=hi;i<n;i+=k){
                    fre[s.charAt(i)-'a']++;
                }

                int mx = 0;
                int tot = 0;
                for (int i=0;i<26;++i){
                    tot += fre[i];
                    mx = Math.max(fre[i], mx);
                }
                ans += tot-mx;
                ++lo;
                --hi;
            }
            System.out.println(ans);
        }
    }
}
