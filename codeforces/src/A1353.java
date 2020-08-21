import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String in[] = br.readLine().trim().split(" ");
            long n = Long.parseLong(in[0]);
            long m = Long.parseLong(in[1]);
            if (n==1){
                System.out.println(0);
            } else if(n == 2){
                System.out.println(m);
            } else {
//                long l1 = m/2;
//                long l2 = m/2;
//                if (m % 2 == 1) {
//                    l2++;
//                }
//                long ans = 0;
//                if (n  ==  3){
//                    ans = l1+l2;
//                } else if(n == 4){
//                    ans = Math.max(l1*2L + l2, l2*2L + l1);
//                } else {
//                    ans = (l1*2L) + (l2*2L);
//                }
                System.out.println(m*2L);
            }
        }
    }
}
