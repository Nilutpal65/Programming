import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class bishuAndHisGirlfriend {


    static ArrayList<Integer>[] gr;
    static int hasGirl[] = new int[1111];
    static int visit[] = new int[1111];
    static int ans = 1111;
    static void dfs(int v, int parent, int distance) {
        if (visit[v] == 1) return;
        visit[v] = 1;
        if (hasGirl[v] == 1) {
            ans = Math.min(ans, v);
            return;
        }
        for (int u:gr[v]) {
            if (u == parent) continue;
            dfs(u, v, distance + 1);
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        gr = new ArrayList[n+1];
        for (int i=0;i<=n;++i) {
            gr[i] =  new ArrayList<>();
        }
        for(int i=1;i<=n-1;++i) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            gr[u].add(v);
            gr[v].add(u);
        }
        int k = Integer.parseInt(br.readLine());
        for (int i=1;i<k;++i) {
            int u = Integer.parseInt(br.readLine());
            hasGirl[u] = 1;
        }
        dfs(1,-1, 0);
        System.out.println(ans);
    }

}