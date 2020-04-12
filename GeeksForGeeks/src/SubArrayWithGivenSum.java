import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String in[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(in[0]);
            int S = Integer.parseInt(in[1]);
            in = br.readLine().split(" " );
            int a[] = new int[n+1];
            Map<Integer, Integer> hash = new HashMap<>();
            hash.put(0, -1);
            int cur = 0;
            boolean noans = true;
            for (int i=0;i<n;++i){
                a[i] = Integer.parseInt(in[i]);
                if(i>0) a[i]+=a[i-1];
                int res = a[i] - S;
                if (hash.containsKey(res)){
                    noans = false;
                    System.out.println((hash.get(res)+1+1) + " "  + (i+1));
                    break;
                }
                hash.put(a[i], i);
            }
            if(noans){
                System.out.println(-1);
            }
        }
    }
}
