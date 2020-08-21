
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().trim().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        in = br.readLine().trim().split(" ");
        int a[] = new int[n];
        for (int i=0;i<n;++i) {
            a[i] = Integer.parseInt(in[i]);
        }
        int cnt = 0;
        for (int i=0;i<n;++i) {
            if (a[i]>=a[m-1] && a[i]>0){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
