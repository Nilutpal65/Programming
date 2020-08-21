import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A57 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().trim().split(" ");
        int a[] = new int[5];
        for (int i=0;i<5;++i) {
            a[i] = Integer.parseInt(in[i]);
        }
        /**
         * simple loop, if reaches corner change direction
         * Take minimum of road - perimeter
         */

        int perimeter = a[0] * 4;

        int n = a[0];

        int x1 = a[1];
        int y1 = a[2];

        int x2 = a[3];
        int y2 = a[4];
        int ans = 0;
        while(true) {
            if (x1==x2 && y1==y2){
                break;
            }
            ans++;

            // System.out.println(x1 + " " + y1);
            if ((x1 == 0) && (y1 == 0)) {
                ++x1;
            } else if ((x1==n) && (y1==0)) {
                ++y1;
            } else if ((x1==n) && (y1==n)) {
                --x1;
            } else if ((x1==0) && (y1==n)){
                --y1;
            } else if (y1==0) {
                ++x1;
            } else if (x1==n){
                ++y1;
            } else if (y1==n) {
                --x1;
            } else {
                --y1;
            }
        }
        System.out.println(Math.min(ans, perimeter-ans));
    }
}
