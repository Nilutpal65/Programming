import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1288 {

//    static int concat(int a, int b){
//        int d = 0;
//        int b1 = b;
//        while (b>0){
//            d++;
//            b/=10;
//        }
//        d = (int) Math.pow(10, d);
//        int res = a*d+b1;
//        return res;
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test  = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String in[] = br.readLine().trim().split(" ");
            long x = Long.parseLong(in[0]);
            long y = Long.parseLong(in[1]);
            long cur = 0;
            long cnt = 0;
            while (cur<y){
                cur = cur*10 + 9;
                if (cur>y){
                    break;
                }
                ++cnt;
            }
            long ans = x * cnt;
            System.out.println(ans);
        }


//        for (int i=1;i<=1000;++i){
//            for (int j=1; j<=1000; ++j){
//                int res = i+j + (i*j);
//                if (res == concat(i,j)){
//                    System.out.println(i + " " + j);
//                }
//            }
//        }
    }
}
