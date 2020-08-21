import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public class CROADS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String in[] = br.readLine().trim().split(" ");


//        long two[] = new long[20];
//        Map<Long, Boolean>M = new HashMap<>();
//        for (int i=1;i<20;++i){
//            two[i]  =1L<<i;
//            M.put(two[i], true);
//        }



        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){

            Long n = Long.parseLong(br.readLine());


            if ((n & (n-1L)) == 0L){
                System.out.println(-1);
                continue;
            }

            long res = 0;
            long i=0;

            for (i = 1; i<=n; i<<=1){
                long c = (n+i)/(i<<1);
                res += ((c-1)*i);
            }

            res += (i-2);

            System.out.println(res);
        }
    }
}
