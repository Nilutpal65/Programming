import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            String in[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(in[0]);
            int k = Integer.parseInt(in[1]);

            int ans = 0;

            if (k>=n) {
                ans = k - n;
            } else {
                if ((n%2) != (k%2)) {
                    ans = 1;
                }
            }

            System.out.println(ans);
        }
    }
}
