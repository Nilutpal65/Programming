import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B137 {
    static int mem[] = new int[5001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String in[] = br.readLine().trim().split(" ");
        for(int i=0;i<n;++i){
            int x = Integer.parseInt(in[i]);
            mem[x]++;
        }
        for (int i=1;i<=n;++i){
            if(mem[i]>=1) --mem[i];
        }
        int ans = 0;
        for (int i=1;i<=5000;++i){
            ans += mem[i];
        }
        System.out.println(ans);
    }
}
