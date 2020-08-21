import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1332 {
    /**
     * http://codeforces.com/problemset/problem/1332/B
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)throws IOException {
        List<Integer> primes = new ArrayList<>();
        for (int i=2;i<510;++i){
            boolean isPrime = false;
            for (int j=2;j<=Math.sqrt(i);++j){
                if (i%j == 0){
                    isPrime = true;
                    break;
                }
            }
            if (!isPrime){
                primes.add(i);
            }
        }


        int dp[] = new int[1001];
        Arrays.fill(dp, 0);
        int color = 1;
        for (Integer i:primes){
            int cur = i;
            while (cur<1001){
                if (dp[cur] == 0){
                    dp[cur] = color;
                }
                cur+=i;
            }
            color++;
            if (color>11) color-=11;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            String in[] = br.readLine().trim().split(" ");
            int a[] = new int[n];
            Set<Integer>s = new HashSet<>();
            Map<Integer, Integer> hash = new HashMap<>();
            s.clear();
            int cnt = 1;
            for (int i=0;i<n;++i){
                a[i] = Integer.parseInt(in[i]);
                s.add(dp[a[i]]);
                if (!hash.containsKey(dp[a[i]])){
                    hash.put(dp[a[i]], cnt++);
                }
            }
            System.out.println(s.size());
            for (int i=0;i<n;++i){
                System.out.print(hash.get(dp[a[i]]) + " ");
            }
            System.out.println("");
        }
    }
}
