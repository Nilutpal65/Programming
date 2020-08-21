import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class B1399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            String in[] = br.readLine().trim().split(" ");
            int a[] = new int[n];


            int mn1 = Integer.MAX_VALUE;
            boolean isEqual1 = true;
            for (int i=0;i<n;++i) {
                a[i] = Integer.parseInt(in[i]);
                mn1 = Math.min(mn1, a[i]);
            }
            for (int i=0;i<n;++i) {
                if (a[i] != mn1) {
                    isEqual1 = false;
                    break;
                }
            }
            if (!isEqual1) {
                for (int i=0;i<n;++i) {
                    a[i] -= mn1;
                }
            }


            in = br.readLine().trim().split(" ");
            int b[] = new int[n];
            int mn2 = Integer.MAX_VALUE;
            boolean isEqual2 = true;
            for (int i=0;i<n;++i) {
                b[i] = Integer.parseInt(in[i]);
                mn2 = Math.min(mn2, b[i]);
            }
            for (int i=0;i<n;++i) {
                if (b[i] != mn2) {
                    isEqual2 = false;
                    break;
                }
            }
            if (!isEqual2) {
                for (int i=0;i<n;++i) {
                    b[i] -= mn2;
                }
            }

            long ans = 0;
            if (isEqual1 && isEqual2) {

            } else if (isEqual1) {
                for (int i=0;i<n;++i) {
                    ans += b[i];
                }
            } else if (isEqual2) {
                for (int i=0;i<n;++i) {
                    ans += a[i];
                }
            } else {
                for (int i=0;i<n;++i) {
                    ans += Math.max(a[i], b[i]);
                }
            }

            System.out.println(ans);
        }
    }
}
