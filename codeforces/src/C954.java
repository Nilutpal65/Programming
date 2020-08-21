import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C954 {
    static int row = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String in[] = br.readLine().trim().split(" ");
        long a[] = new long[n];
        for (int i=0; i<n; ++i) {
            a[i] = Long.parseLong(in[i]);
        }
        long X = 1000000000;
        long Y = 0;
        for (int i=1; i<n; ++i){
            long d = Math.abs(a[i] - a[i-1]);
            if (d == 1) continue;
            if (Y == 0){
                Y = d ;
                continue;
            }
            if (Y!=0 && Y!=d){
                System.out.println("NO");
                return;
            }
        }

        if (Y == 0) Y = 1000000000;

        for(int i=1;i<n;++i){
            if (Math.abs(a[i]-a[i-1]) == Y) continue;
            if (a[i]-a[i-1] == 1 && ( (a[i-1]-1)%Y != (Y-1) )) continue;
            if (a[i]-a[i-1] == -1 && ( (a[i-1]-1)%Y != 0 )) continue;
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
        System.out.println(X + " " + Y);
    }
}
