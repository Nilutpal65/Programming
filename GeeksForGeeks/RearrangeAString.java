import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RearrangeAString {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0){
            String s = br.readLine();
            int tot = 0;
            char c[] = new char[s.length()];
            for (int i=0;i<s.length();++i) {
                c[i] = s.charAt(i);
                if (c[i] >= '0' && c[i] <= '9'){
                    tot += c[i] - '0';
                    c[i] = '0';
                }
            }
            Arrays.sort(c);
            String ans = "";
            for (int i=0;i<c.length;++i) {
                if (c[i] != '0') {
                    ans += c[i];
                }
            }
            ans = ans + tot;
            System.out.println(ans);
        }
    }
}
