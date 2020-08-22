import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){

            long ans = 0;

            String in[] = br.readLine().trim().split(" ");
            long x1 = Long.parseLong(in[0]);
            long x2 = Long.parseLong(in[1]);
            long x3 = Long.parseLong(in[2]);

            in = br.readLine().trim().split(" ");
            long y1 = Long.parseLong(in[0]);
            long y2 = Long.parseLong(in[1]);
            long y3 = Long.parseLong(in[2]);

            long res = Math.min(x3 , y2);

            ans += (res * 2);
            x3 -= res;
            y2 -= res;

            res = Math.min(x1, y3);
            x1 -= res;
            y3 -= res;

            res = Math.min(x2, y1);
            x2 -= res;
            y1 -= res;

            res = Math.min(x2, y2);
            x2 -= res;
            y2 -= res;

            res = Math.min(x2, y3);
            x2 -= res;
            y3 -= res;

            ans += (-res * 2);

            System.out.println(ans);
        }
    }
}
