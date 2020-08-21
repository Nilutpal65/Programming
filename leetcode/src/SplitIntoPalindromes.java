import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SplitIntoPalindromes {

    static boolean dp[][] = new boolean[5001][5001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String in[] = br.readLine().trim().split(" ");
        String word = br.readLine();

        int n = word.length();

        for (int i=0;i<n;++i) dp[i][i]=true;

        for (int i=0;i<n-1;++i){
            if (word.charAt(i)==word.charAt(i+1)) dp[i][i+1]=true;
            else dp[i][i+1]=false;
        }


        int sz=2;
        for (int i=0;i<n-2;++i) {
            for (int j=0;j<n-sz;++j) {
                if(word.charAt(j) == word.charAt(j+sz)) {
                    if (dp[j+1][j+sz-1]){
                        dp[j][j+sz]=true;
                    } else {
                        dp[j][j+sz]=false;
                    }
                } else {
                    dp[j][j+sz]=false;
                }
            }
            ++sz;
        }

        int ansi = -1;
        int ansj = -1;

        for (int i=0;i<n;++i){
            if(dp[0][i]){
                for (int j = i+1;j<n-1;++j){
                    if (dp[i+1][j] && dp[j+1][n-1]){
                        ansi = i;
                        ansj = j;
                        break;
                    }
                }
                if (ansi!=-1) break;
            }
        }

        if (ansi!=-1){
            System.out.println(word.substring(0, ansi+1));
            System.out.println(word.substring(ansi+1, ansj+1));
            System.out.println(word.substring(ansj+1, n));
        }


    }
}
