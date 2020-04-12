import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMPSearch {
    static int lps[] = new int[212345];
    static boolean match(String needle, String haystack){
        int i = 0;
        int j = 0;
        while(i<haystack.length()){
            if (needle.charAt(j) == haystack.charAt(i)){
                ++i;
                ++j;
            }
            if (j == needle.length()){
                return true;
            } else {
                if (i<haystack.length()){
                    if (j!=0){
                        j = lps[j];
                    } else {
                        ++i;
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    static int calcPrefix(String s, int n){
        int i = 0;
        int j = 1;
        int ans = 0 ;
        while(j < n){
            if (s.charAt(i) == s.charAt(j)){
                ++i;
                lps[j]=i;
                ans = Math.max(lps[j], ans);
                ++j;
            } else {
                if (i!=0){
                    i = lps[i-1];
                } else {
                    lps[j]=0;
                    ++j;
                }
            }
        }
        return ans;
//        for (int k=0;k<n;++k){
//            System.out.print(lps[k] + " " );
//        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String s = br.readLine();
            System.out.println(calcPrefix(s, s.length()));
        }
    }
}
