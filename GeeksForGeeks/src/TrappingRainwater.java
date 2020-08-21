import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrappingRainwater {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            String in[] = br.readLine().trim().split(" " );
            int a[] = new int[n];
            for (int i=0;i<n;++i){
                a[i] = Integer.parseInt(in[i]);
            }
            int left_max = 0;
            int right_max = 0;
            int i = 0;
            int j = n-1;
            int ans = 0;
            while (i<j){
                if (a[i]<a[j]){
                    if (a[i]>left_max){
                        left_max = a[i];
                    } else {
                        ans += left_max-a[i];
                    }
                    ++i;
                } else {
                    if (a[j]>right_max){
                        right_max = a[j];
                    } else {
                        ans += right_max-a[j];
                    }
                    --j;
                }
            }
            System.out.println(ans);
        }
    }
}
