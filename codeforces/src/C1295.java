import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C1295 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String s = br.readLine();
            String z = br.readLine();
            int dp[][] = new int[s.length()][27];
            int firstIndex[] = new int[27];
            Arrays.fill(firstIndex, -1);
            for (int i=0;i<s.length();++i) Arrays.fill(dp[i], -1);
            for (int i=0;i<s.length();++i){
                if (firstIndex[s.charAt(i)-'a'] == -1){
                    firstIndex[s.charAt(i)-'a']=i;
                }
            }
            if (s.length() > 1){
                for (int i=s.length()-2;i>=0;--i){
                    dp[i][s.charAt(i+1)-'a'] = i+1;
                    for (int j=0;j<26;++j){
                        if (j!=(s.charAt(i+1)-'a')){
                            dp[i][j] = dp[i+1][j];
                        }
                    }
                }
            }
            Arrays.fill(dp[s.length()-1], 0);
            int i = 0;
            int cnt = 0;
            int cur = 0;
            while(i<z.length()){
                if (cur == 0) cnt++;
                if (dp[cur][z.charAt(i)-'a'] != -1){
                    cur = dp[cur][z.charAt(i)-'a'];
                    ++i;
                } else {
                    if (firstIndex[z.charAt(i)-'a'] != -1){
                        cur = firstIndex[z.charAt(i)-'a'];
                        if(cur!=0){
                            cnt++;
                        }
                        ++i;
                    } else {
                        break;
                    }
                }
            }
            if (i==z.length()){
                System.out.println(cnt);
            } else {
                System.out.println(-1);
            }
        }
    }
}
