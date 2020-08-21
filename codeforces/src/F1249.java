import javax.annotation.processing.SupportedSourceVersion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class F1249 {
    static List<Integer>gr[];
    static int a[];
    static int n;
    static int m;

    static int sum = 0;
    static int dp[][];
    static void dfs(int v, int parent){
        dp[v][0] = a[v];
        for (Integer e:gr[v]){
            if (e != parent){
                dfs(e, v);
            }
        }
        for (int depth = 0; depth < n; ++depth) {
            if (depth == 0){
                for (Integer e:gr[v]){
                    if (e!=parent){
                        dp[v][depth] += dp[e][Math.max(0, m-1)];
                    }
                }
            } else {
                for (Integer e:gr[v]){
                    if (e!=parent){
                        int cur = dp[e][depth-1];

                        for (Integer other:gr[v]){
                            if (other==parent || other==e){
                                continue;
                            }
                            cur += dp[other][Math.max(depth-1, m-depth-1)];
                        }
                        dp[v][depth] = Math.max(dp[v][depth], cur);
                    }
                }
            }
        }
        for (int depth=n-1; depth>0;--depth){
            dp[v][depth-1] = Math.max(dp[v][depth-1], dp[v][depth]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().trim().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        ++m;

        gr = new ArrayList[n+1];
        a = new int[n+1];
        dp = new int[n+1][n+1];

        in =  br.readLine().trim().split(" ");

        for (int i=0;i<n;++i){
            a[i] = Integer.parseInt(in[i]);
            gr[i] = new ArrayList<>();
        }

        for (int i=0;i<n-1;++i){
            int u;
            int v;
            in =  br.readLine().trim().split(" ");
            u  = Integer.parseInt(in[0]);
            v = Integer.parseInt(in[1]);
            --u;
            --v;
            gr[u].add(v);
            gr[v].add(u);
        }
        dfs(0, -1);
        System.out.println(dp[0][0]);
    }
}
