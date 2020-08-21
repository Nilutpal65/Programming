import java.util.HashMap;
import java.util.Map;

public class AiAndAjEquals0 {
    static int N = 5;

    public static void main(String[] args){
        int a[] = { 5, 4, 1, 6 };
        countPairs(a, a.length);
        //System.out.println(countPairs(a, a.length));
    }

    static void countPairs(int a[], int n)
    {
        // stores the frequency of each number
        Map<Integer, Integer> hash =  new HashMap<>();

        long dp[][] = new long[1 << N][N + 1];


        // count the frequency of every element
        for (int i = 0; i < n; ++i)
            if (hash.containsKey(a[i]))
                hash.put(a[i], hash.get(a[i])+1);
            else
                hash.put(a[i],1);

        // iterate for al possible values that a[i] can be
        for (int mask = 0; mask < (1 << N); ++mask) {

        // if the last bit is ON
        if ((mask & 1) > 0) {
            if (hash.containsKey(mask)) dp[mask][0]+=hash.get(mask);
            if (hash.containsKey(mask^1)) dp[mask][0]+=hash.get(mask^1);
        } else {
            if (hash.containsKey(mask)) dp[mask][0]+=hash.get(mask);
        }
        // iterate till n
        for (int i = 1; i <= N; ++i) {

            // if mask's ith bit is set
            if ((mask & (1 << i)) > 0)
            {
                dp[mask][i] = dp[mask][i - 1] +
                        dp[mask ^ (1 << i)][i - 1];
            }
            else // if mask's ith bit is not set
                dp[mask][i] = dp[mask][i - 1];
        }
    }

        for (int i=0;i<(1<<N);++i){
            for (int j=0;j<=N;++j){
                System.out.print(dp[i][j]+" " );
            }
            System.out.println("");
        }

        long ans = 0;

        // iterate for all the array element
        // and count the number of pairs
        for (int i = 0; i < n; i++)
            ans += dp[((1 << N) - 1) ^ a[i]][N];

        // return answer
        // return ans;
    }
}
