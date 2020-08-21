import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A348 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String in[] = br.readLine().trim().split(" ");
        int a[] = new int[n];
        long tot = 0;
        int mx = 0;
        for(int i=0;i<n;++i){
            a[i] = Integer.parseInt(in[i]);
            tot += a[i];
            mx = Math.max(a[i], mx);
        }
        --n;
        long ans = (long) Math.ceil((double) tot/(double) (n));
        if(mx>ans){
            ans = mx;
        }
        System.out.println(ans);
    }
}
