import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;

public class ZCO13001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long a[] = new long[n];
        String in[] = br.readLine().trim().split(" ");
        for (int i=0;i<n;++i) {
            a[i] = Long.parseLong(in[i]);
        }
        Arrays.sort(a);
        long pre = a[0];
        long ans = 0;
        for (int i=1;i<n;++i){
            ans += (a[i]*i*1L - pre);
            pre += a[i];
        }
        System.out.println(ans);
    }
}
