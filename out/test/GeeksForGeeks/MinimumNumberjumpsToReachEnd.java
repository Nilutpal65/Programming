import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumNumberjumpsToReachEnd {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            String in[] = br.readLine().split(" ");
            int a[] =  new int[n+1];
            for (int i=0; i<n; ++i){
                a[i] = Integer.parseInt(in[i]);
            }
            int start = a[0];
            int jump = 1;
            int mx = a[0];
            for (int i=1;i<n;++i) {
                mx = Math.max(mx, a[i]+i);
                --start;
                if (start == 0){
                    start = mx-i;
                    if (i != n-1) {
                        ++jump;
                        mx = -1;
                    } else {
                        break;
                    }
                }
            }
            if (start<0) {
                jump=-1;
            }
            System.out.println(jump);
        }
    }
}
/**
 1
 11
 1 3 5 8 9 2 6 7 6 8 9
 */