import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A279634 {
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
            seg = new Data[20];
            a = new int[20];
        }

        Data combine(Data a, Data b){
            Data res = new Data(0);
            res.sum = a.sum + b.sum;
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
        void update(int v, int tl, int tr, int l, int r, int new_val) {
            if (l>tr || r<tl) return;
            if (tl >= l && tr<=r ) {
                seg[v].sum += new_val;
            } else {
                int tm = (tl + tr) / 2;
                update(v*2, tl, Math.min(tr, tm), l, r, new_val);
                update(v*2 + 1, Math.max(tm+1, tl), tr, l, r, new_val);
                seg[v] = combine(seg[v*2], seg[v*2+1]);
            }
        }

        //Seg.query(1, 0, a.length - 1, 0, 2) l,r - 0 based
        long query(int v, int tl, int tr, int l, int r, long s) {
            if (l>tr || r<tl) return 0;
            if (tl >= l && tr<=r ) {
                return seg[v].sum;
            }
            long sum = 0;
            int tm = (tl + tr) / 2;
            sum += query(v*2, tl, Math.min(tr, tm), l, r, s + sum);
            sum += query(v*2 + 1, Math.max(tm+1, tl), tr, l, r, s + sum);
            return sum;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        SegmentTree Seg = new SegmentTree();
        Seg.build(1, 0, n-1);
        for (int i=0;i<m;++i) {
            int choice  =fs.nextInt();
            if (choice == 1) {
                int l = fs.nextInt(), r = fs.nextInt(), new_val = fs.nextInt();
                Seg.update(1, 0, n-1, l, r - 1, new_val);
            } else {
                int x = fs.nextInt();
                System.out.println(Seg.query(1, 0, n-1, x, x, 0));
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
