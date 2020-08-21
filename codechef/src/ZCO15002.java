import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ZCO15002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().trim().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);


        in = br.readLine().trim().split(" ");
        int a[] = new int[n];
        for (int i=0;i<n;++i){
            a[i] = Integer.parseInt(in[i]);
        }
        int ans = 0;

        Arrays.sort(a);

        for (int i = 0;i<n;++i) {

            int lo = i+1;
            int hi = n-1;
            int pos = -1;

            while (lo<=hi){
                int mid = (lo + hi) /2 ;
                if (Math.abs(a[i] - a[mid]) >= k) {
                    hi = mid-1;
                    pos = mid ;
                } else {
                    lo = mid + 1;
                }
            }
            if (pos!=-1 && pos<n && (Math.abs(a[i] - a[pos]) >= k)) {
                ans += (n - pos);
            }
        }
        System.out.println(ans);
    }
}
