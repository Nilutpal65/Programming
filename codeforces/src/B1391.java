import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1391 {
    static boolean solve(char c[][], int n, int m, int x, int y){
        if (x==n-1 && y==m-1) return true;
        if (x>=0 && x<=n-1 && y>=0 && y<=m-1){
            if (c[x][y] == 'R') {
                return solve(c,n,m,x,y+1);
            }
            if (c[x][y] == 'D') {
                return solve(c,n,m,x+1,y);
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String in[] = br.readLine().trim().split(" ");
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String in[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(in[0]);
            int m = Integer.parseInt(in[1]);
            char c[][] = new char[n][m];
            for (int i=0;i<n;++i){
                String s = br.readLine();
                for (int j=0;j<m;++j){
                    c[i][j] = s.charAt(j);
                }
            }
            int count  = 0;
            for (int i=0;i<n;++i){
                for (int j=0;j<m;++j){
                    if (solve(c,n,m,i,j)){
                        //System.out.println(i + " " + j);
                        count++;
                    }
                }
            }
            int res1 = (n*m) - count;
            int res2 = 0;
            for (int i=0;i<n;++i){
                if (c[i][m-1] == 'R') res2++;
            }
            for (int i=0;i<m;++i){
                if (c[n-1][i] == 'D') res2++;
            }
            System.out.println(Math.min(res1, res2));
        }
    }
}
