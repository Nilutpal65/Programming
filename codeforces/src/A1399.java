import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.HashSet;
        import java.util.Set;

public class A1399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            String in[] = br.readLine().trim().split(" ");
            int a[] = new int[n];
            for (int i=0;i<n;++i) {
                a[i]  = Integer.parseInt(in[i]);
            }
            Arrays.sort(a);
            boolean can = true;
            for (int i=1;i<n;++i) {
                if (a[i] - a[i-1] > 1){
                    can = false;
                    break;
                }
            }
            if (can) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
