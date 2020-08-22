import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class D1401 {


    static List<Integer>gr[];
    static int size[];
    static Map<Pair, Boolean> edges;

    static int dfs(int v, int parent){
        int si = 1;
        for (Integer e:gr[v]){
            if (e == parent) continue;
            si += dfs(e, v);
        }
        size[v] = si;
        return size[v];
    }

    static int dfs2(int v, int parent){

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            gr = new ArrayList[n+1];
            size = new int[n+1];
            for (int i=0;i<=n;++i){
                gr[i] = new ArrayList<>();
            }
            for (int i=0;i<n;++i){
                String in[] = br.readLine().trim().split(" ");
                int u = Integer.parseInt(in[0]);
                int v = Integer.parseInt(in[1]);
                gr[u].add(v);
                gr[v].add(u);
            }
            dfs(1, -1);
        }
    }
}
