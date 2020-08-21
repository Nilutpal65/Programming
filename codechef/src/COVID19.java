import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class COVID19 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            String in[] = br.readLine().trim().split(" ");
            int a[] = new int[n];
            for (int i=0;i<n;++i){
                a[i] = Integer.parseInt(in[i]);
            }
            Arrays.sort(a);
            int mem[] = new int[11];
            Arrays.fill(mem, 0);
            int cnt = 1;
            mem[1]=1;
            for (int i=1;i<n;++i){
                if (a[i]-a[i-1]>2){
                    cnt++;
                }
                mem[cnt]++;
            }
            int mx = Integer.MIN_VALUE;
            int mn = Integer.MAX_VALUE;
            for (int i=1;i<=cnt;++i){
                if (mem[i]>0){
                    if (mem[i]>mx){
                        mx = mem[i];
                    }
                    if (mem[i]<mn){
                        mn = mem[i];
                    }
                }
            }
            System.out.println(mn + " " + mx);
        }
    }
}
