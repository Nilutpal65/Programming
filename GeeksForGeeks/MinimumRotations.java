import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class MinimumRotations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String in[] = br.readLine().trim().split(" ");
            int ans = 0;
            for (int i=0;i<in[0].length();++i){
                int x = in[0].charAt(i) - '0';
                int y = in[1].charAt(i) - '0';
                int xx = x;
                int cnt1 = 0;
                while (x!=y){
                    x = (x+1)%10;
                    ++cnt1;
                }
                int cnt2 = 0;
                while (xx!=y){
                    xx = (xx-1)%10;
                    ++cnt2;
                    if (xx<0) xx=9;
                }
                ans += Math.min(cnt1, cnt2);
            }
            System.out.println(ans);
        }
    }
}
