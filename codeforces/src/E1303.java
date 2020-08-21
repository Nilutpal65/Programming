import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E1303 {
    static String s,t;
    static int nxt[][] = new int[401][27];

    static boolean calc(String a, String b){
        int dp[][] = new int[a.length()+1][b.length()+1];
        for (int i=0;i<a.length()+1;++i){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i=0;i<a.length()+1;++i){
            for (int j=0;j<b.length()+1;++j){

                if (dp[i][j] > s.length()){
                    continue;
                }
                int len = dp[i][j];
                if(i<a.length() && nxt[len][a.charAt(i)-'a']<Integer.MAX_VALUE) {
                    dp[i+1][j] = Math.min(dp[i+1][j], nxt[len][(a.charAt(i)-'a')] + 1);
                }
                if(j<b.length() && nxt[len][b.charAt(j)-'a']<Integer.MAX_VALUE) {
                    dp[i][j+1] = Math.min(dp[i][j+1], nxt[len][(b.charAt(j)-'a')] + 1);
                }
            }
        }

//        System.out.println(a + " " + b);
//        for (int i=0;i<a.length()+1; ++i){
//            for (int j =0;j<b.length()+1; ++j){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println("");
//        }
        return dp[a.length()][b.length()]<Integer.MAX_VALUE;
    }

    static void solve()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine().trim();
        t = br.readLine().trim();

        for (int i=0;i<401; ++i){
            Arrays.fill(nxt[i], Integer.MAX_VALUE);
        }
        for (int i=s.length()-1; i>=0; --i){
            nxt[i] = nxt[i+1];
            nxt[i][s.charAt(i)-'a'] = i;
        }
        for (int i=0;i<t.length();++i){
            if(calc(t.substring(0, i), t.substring(i, t.length()))){
                System.out.println("YES");
//                System.out.println("******");
                return;
            }
        }
        System.out.println("NO");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            solve();
        }
    }
}
