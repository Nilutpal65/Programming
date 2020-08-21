import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A1292 {

    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().trim().split(" ");

        int n = Integer.parseInt(in[0]);
        int q = Integer.parseInt(in[1]);
        boolean go = true;
        int cnt[][] = new int[n+1][2];

        Arrays.fill(cnt[0], 0);
        Arrays.fill(cnt[1], 0);

        int row=0;
        int diag1=0;
        int diag2=0;

        for (int i=0;i<q;++i){
            in = br.readLine().trim().split(" ");
            int y = Integer.parseInt(in[0]);
            int x = Integer.parseInt(in[1]);
            --y; --x;
            //cnt[x][y] = (cnt[x][y] == 0) ? 1 : 0;
            if (cnt[x][y] == 0){
                cnt[x][y] = 1;
                if (y==0 && x!=n-1 && cnt[x][y+1]==1) row++;
                if (y==1 && x!=0 && cnt[x][y-1]==1) row++;
                if (y==0 && cnt[x-1][y+1]==1) diag1++;
                if (y==0 && x+1!=n-1 && cnt[x+1][y+1]==1) diag2++;
                if (y==1 && cnt[x+1][y-1]==1) diag1++;
                if (y==1 && x-1>=1 && cnt[x-1][y-1]==1) diag2++;
            } else {
                cnt[x][y] = 0;
                if (y==0 && x!=n-1 && cnt[x][y+1]==1) row--;
                if (y==1 && x!=0 && cnt[x][y-1]==1) row--;
                if (y==0 && cnt[x-1][y+1]==1) diag1--;
                if (y==0 && x+1!=n-1 && cnt[x+1][y+1]==1) diag2--;
                if (y==1 && cnt[x+1][y-1]==1) diag1--;
                if (y==1 && x-1>=1 && cnt[x-1][y-1]==1) diag2--;
            }

            if (row>0 || diag1>0 || diag2>0){
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
