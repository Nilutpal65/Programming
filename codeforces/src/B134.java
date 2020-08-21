import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B134 {
    static int solve(int x, int y){
        int cnt = 0;
        if (x==1 && y==1) return 0;
        while (true){
            if (x==0 || y==0) return Integer.MAX_VALUE;
            if (x==1 || y==1) return (cnt + Math.max(x,y)-1);
            if (x>y)
                x-=y;
            else
                y-=x;
            cnt++;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = Integer.MAX_VALUE;
        for (int i=1;i<=n;++i){
            ans = Math.min(ans, solve(n,i));
        }
        if (n<=2)
            ans = n-1;
        System.out.println(ans);
    }
}
