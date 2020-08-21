import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHANDF {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 5;
        for (int mask = 0; mask < (1<<n); mask++){
            // iterate over all the subsets of the mask
            for(int i = mask; i > 0; i = (i-1) & mask){
                System.out.print(i + " ");
            }
            System.out.println("\n-------");
        }

//        int test = Integer.parseInt(br.readLine());
//        while (test-- > 0){
//            String in[] = br.readLine().trim().split(" ");
//            int x = Integer.parseInt(in[0]);
//            int y = Integer.parseInt(in[1]);
//            int l = Integer.parseInt(in[2]);
//            int r = Integer.parseInt(in[3]);
//
//            long res = 0;
//            long max = 0;
//
//            for (int i=l;i<=r;++i){
//                long ans = (x&i) * (y&i);
//                if (ans > max){
//                    max = ans;
//                    res = i;
//                }
//            }
//
//            System.out.println(res);
//        }

    }
}
