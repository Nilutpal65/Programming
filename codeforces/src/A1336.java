import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A1336 {
    static ArrayList<Integer>[] gr, hg;
    static int parent[] = new int[212345];
    static int size[] = new int[212345];
    static int height__tree[] = new int[212345];
    static boolean blacklisted[] = new boolean[212345];
    static int max_height = 0;
    static long solve(int v){
        long cnt = 1;
        while (v!=1){
            if (!blacklisted[v]) cnt++;
            v = parent[v];
        }
        return cnt;
    }

    static int dfs2(int cur, int pa,int height){
        int sz=1;
        for (int v:gr[cur]){
            if (v == pa) continue;
            sz += dfs2(v, cur, height + 1);
        }
        size[cur] = sz;
        parent[cur] = height;
        height__tree[cur] = size[cur] - height;
        return size[cur];
    }

    static class cmp implements Comparator<Integer>{
        public int compare(Integer a, Integer b){
            return size[a]-size[b];
        }
    }
    static class Pair{
        int in1;
        int in2;
        public Pair(){

        }
        public Pair(int in1, int in2){
            this.in1 = in1;
            this.in2 = in2;
        }
    };
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().trim().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);
        gr = new ArrayList[n+1];
        hg = new ArrayList[n+1];
        for (int i=0;i<=n;++i){
            gr[i] = new ArrayList<>();
            hg[i] = new ArrayList<>();
        }
        Arrays.fill(parent, 0);
        Arrays.fill(blacklisted, false);
        Arrays.fill(size, 0);
        max_height = 0;
        for (int i=0;i<n-1;++i) {
            in = br.readLine().trim().split(" ");
            int u = Integer.parseInt(in[0]);
            int v = Integer.parseInt(in[1]);
            gr[u].add(v);
            gr[v].add(u);
        }
        dfs2(1,0, 1);
        height__tree[0] = Integer.MAX_VALUE;
        List<Pair>p = new ArrayList<>();
        for (int i=1;i<=n;++i){
            p.add(new Pair(height__tree[i], i));
            //System.out.println(i + " " + height__tree[i]);
        }
        Collections.sort(p, new Comparator<Pair>() {
            @Override public int compare(Pair p1, Pair p2)
            {
                return p2.in1 - p1.in1;
            }
        });
        int res = n - k;
        long ans = 0;
        for (Pair pcur:p){
            if (res == 0)
                break;
            // System.out.println(pcur.in2 + " " + parent[pcur.in2]);
            ans += height__tree[pcur.in2];
            --res;
        }
        System.out.println(ans);
    }
}
/**
 * 1 2
 * 2 3
 * 3 4
 * 2 5
 * 1 6
 * 6 7
 * 7 8
 */
