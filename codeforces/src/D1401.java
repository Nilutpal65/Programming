import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D1401 {
    static List<Integer>gr[];
    static long size[];
    static long total_size=0;
    static PriorityQueue<Long>P,Q;
    static long  mod = 1_000_000_007L;
    static long dfs(int v, int parent){
        size[v] += 1L;
        for (Integer e:gr[v]){
            if (e == parent) continue;;
            size[v] += dfs(e, v);
        }
        if (v>1){
            long res = size[v] * (total_size - size[v]);
            P.add(res);
            Q.add(res);
        }
        return size[v];
    }
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int test = fs.nextInt();
        while (test-- > 0){
            int n = fs.nextInt();
            gr = new ArrayList[n+1];
            size = new long[n+1];
            total_size = n;
            P = new PriorityQueue<>(new Comparator<Long>() {
                @Override
                public int compare(Long o1, Long o2) {
                    return (o1 < o2) ? 1 : -1;
                }
            });
            Q = new PriorityQueue<>(new Comparator<Long>() {
                @Override
                public int compare(Long o1, Long o2) {
                    return (o1 < o2) ? -1 : 1;
                }
            });
            for(int i=0;i<n+1;++i) gr[i]=new ArrayList<>();
            for (int i=0;i<n-1;++i){
                int u = fs.nextInt(), v= fs.nextInt();
                gr[u].add(v);
                gr[v].add(u);
            }
            dfs(1, -1);
            int p = fs.nextInt();
            long p_arr[] = new long[p];
            for (int i=0;i<p;++i){
                p_arr[i] = fs.nextLong();
            }
            Arrays.sort(p_arr);
            long ans = 0;
            if (p>=n-1){
                int p_cnt = 0;
                while (Q.size() > 1){
                    Long top = Q.peek();
                    Q.poll();
                    ans = (ans + (top * p_arr[p_cnt++] * 1L) % mod) % mod;
                }
                if (!Q.isEmpty()){
                    Long last = Q.peek();
                    Q.poll();
                    for (int i=p_cnt;i<p;++i){
                        last = (last * p_arr[i] * 1L) % mod;
                    }
                    ans = (ans + last) % mod;
                }
            } else {
                for (int i=p-1 ;i>=0; --i){
                    Long last = P.peek();
                    P.poll();
                    ans = (ans + (last * p_arr[i] * 1L) %mod) % mod;
                }
                while (!P.isEmpty()){
                    Long last = P.peek();
                    P.poll();
                    ans = (ans + last) % mod;
                }
            }
            System.out.println(ans);
        }
    }
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
