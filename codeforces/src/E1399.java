import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class E1399 {
    static class Pair {
        long f;
        long s;
        Pair(long f, long s){
            this.f = f;
            this.s = s;
        }
    }

    static PriorityQueue<Pair> P = new PriorityQueue<Pair>(new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            long res1 = ((o2.f - (o2.f/2))*o2.s);
            long res2 = ((o1.f - (o1.f/2))*o1.s);
            int diff = 0;
            if (res2 > res1) diff = -1;
            if (res2 < res1) diff = 1;
            return  diff;
        }
    });

    static List<Pair> gr[] = new ArrayList[200101];
    static int level[] = new int[200101];
    static long total;


    static int dfs(int v, long parent, long tot){
        if (gr[v].size() == 1 && (v != 1)) {
            level[v] = 1;
            total += tot;
            return 1;
        }
        int l = 0;
        int cur = 0;
        for (Pair e:gr[v]){
            if ( e.f == parent) continue;
            cur = dfs((int)e.f, v, tot + e.s);
            l += cur;
            P.add(new Pair(e.s, cur));
        }
        level[v] = l;
        return l;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String in[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(in[0]);
            long S = Long.parseLong(in[1]);
            P.clear();

            for (int i=0;i<=n;++i){
                gr[i] = new ArrayList<>();
            }

            total = 0;

            for (int i=0;i<n-1;++i){
                in = br.readLine().trim().split(" ");
                int u = Integer.parseInt(in[0]);
                int v = Integer.parseInt(in[1]);
                int cost = Integer.parseInt(in[2]);
                gr[u].add(new Pair(v, cost));
                gr[v].add(new Pair(u, cost));
                //total += cost;
            }

            dfs(1, -1, 0);

            int cnt = 0;
            while (total > S && P.size() > 0) {
                cnt++;
                Pair top = P.peek();
                P.poll();
                long oldi = top.f * top.s;
                long newi = (top.f / 2) * top.s;
                total -= oldi;
                total += newi;
                top.f /= 2;
                if (newi > 0) {
                    P.add(top);
                }
            }
            System.out.println(cnt);
        }
    }
}

