import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class E1399 {
    static class Pair {
        int f;
        int s;
        Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }

    static PriorityQueue<Pair> P = new PriorityQueue<Pair>(new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            return ((o2.f - (o2.f/2))*o2.s) - ((o1.f - (o1.f/2))*o1.s);
        }
    });

    static List<Pair> gr[] = new ArrayList[200101];
    static int level[] = new int[200101];
    static long total;


    static int dfs(int v, int parent, long tot){
        if (gr[v].size() == 1 && (v != 1)) {
            level[v] = 1;
            total += tot;
            return 1;
        }
        int l = 0;
        int cur = 0;
        for (Pair e:gr[v]){
            if ( e.f == parent) continue;
            cur = dfs(e.f, v, tot + e.s);
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

//            for (Pair e:P){
//                System.out.println(((e.s - (e.s/2))*e.f));
//            }

            while (total > S) {
                cnt++;
                Pair top = P.peek();
                P.poll();
                int oldi = top.f * top.s;
                int newi = (top.f / 2) * top.s;
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


/**
1
10 28
8 2 8
5 1 4
6 1 10
10 2 7
7 2 1
9 2 1
2 1 5
4 1 9
3 2 5


 */

/**
1
10 135
5 3 9
8 6 6
6 5 8
3 2 10
9 5 6
7 6 8
10 9 10
4 3 5
2 1 6
 */
