import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        String in[] = br.readLine().trim().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        char a[][] = new char[2001][2001];
        for (int i=1;i<=n;++i){
            String ini = br.readLine();
            for (int j=1;j<=m;++j){
                a[i][j] = ini.charAt(j-1);
            }
        }

        int up[][] = new int[2001][2001];
        int down[][] = new int[2001][2001];

        for (int i=2;i<=n;++i){
            for (int j=1;j<=m;++j){
                if (a[i][j] == a[i-1][j]){
                    up[i][j] += up[i-1][j] + 1;
                } else {
                    up[i][j] = 0;
                }
            }
        }

        for (int i=n-1;i>=1;--i){
            for (int j=1;j<=m;++j){
                if (a[i][j] == a[i+1][j]){
                    down[i][j] += down[i+1][j] + 1;
                } else {
                    down[i][j] = 0;
                }
            }
        }

        int L[] = new int[2001];
        int R[] = new int[2001];
        long ans = 0;

        for (int i=1;i<=n;++i) {
            for (int j=1;j<=m;++j){
                int go = j;
                while (go <= m && a[i][j] == a[i][go]) ++go;
                --go;
                for (int pos = j;pos<=go;++pos){
                    if (pos == j) L[pos] = pos;
                    else {
                        L[pos] = Math.max(L[pos - 1], pos - Math.min(up[i][pos], down[i][pos]));
                    }
                }
                j = go;
            }

            for (int j=m;j>=1;--j){
                int go = j;
                while (go>=1 && a[i][j] == a[i][go]) --go;
                ++go;
                for (int pos = j;pos>=go;--pos){
                    if (pos == j) R[pos] = pos;
                    else {
                        R[pos] = Math.min(R[pos + 1], pos + Math.min(up[i][pos], down[i][pos]));
                    }
                }
                j = go;
            }
            for (int j = 1; j <= m; ++j) {
                ans += (long)Math.min(j - L[j] + 1, R[j] - j + 1);
            }
        }
        System.out.println(ans);
    }
}
