import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D273278 {
    static class SegmentTree{
        static class Data{
            long sum;
            Data(long sum){
                this.sum = sum;
            }
            public String toString() {
                return "sum: "+sum;
            }
        }

        static Data seg[];
        static int a[]; // 0 based

        SegmentTree(){
            seg = new Data[405000];
            a = new int[205000];
        }

        Data combine(Data a, Data b){
            Data res = new Data(0);
            res.sum = Math.max(a.sum , b.sum);
            return res;
        }

        //Seg.build(1, 0, a.length - 1);
        void build(int v, int l, int r){
            if (l == r){
                seg[v] = new Data(a[l]);
            } else {
                int mid = (l + r) / 2;
                build(v*2, l , mid);
                build(v*2 + 1, mid + 1, r);
                seg[v] = combine(seg[v*2], seg[v*2+1]);
            }
        }

        //Seg.update(1, 0, a.length - 1, 1, 10); pos - 0 based
        void update(int v, int tl, int tr, int pos, int new_val) {
            if (tl == tr) {
                seg[v] = new Data(new_val);
            } else {
                int tm = (tl + tr) / 2;
                if (pos <= tm)
                    update(v*2, tl, tm, pos, new_val);
                else
                    update(v*2+1, tm+1, tr, pos, new_val);
                seg[v] = combine(seg[v*2], seg[v*2+1]);
            }
        }

        //Seg.query(1, 0, a.length - 1, 0, 2) l,r - 0 based
        int query(int v, int tl, int tr, int l, int r, long sum, int in) {
            if (sum > seg[v].sum){
                return -1;
            }
            if (tl == tr) {
                return tl;
            }
            int mid = (tl + tr) / 2;
            if (seg[v*2].sum >= sum && mid <= in){
                return query(v*2, tl, mid, l, Math.min(r, mid), sum, in);
            } else {
                return query(v*2+1, mid+1, tr, Math.max(l, mid+1), r, sum, in);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        SegmentTree T = new SegmentTree();
        for (int i = 0; i<n; ++i){
            T.a[i] = fs.nextInt();
        }
        T.build(1, 0, n-1);
        for (int i=0;i<m;++i){
            int x = fs.nextInt();
            if (x == 2){
                int y = fs.nextInt(), z = fs.nextInt();
                System.out.println(T.query(1, 0, n - 1, 0, n-1, y, z));
            } else {
                int y = fs.nextInt(), z = fs.nextInt();
                T.update(1, 0, n - 1, y, z);
            }
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
