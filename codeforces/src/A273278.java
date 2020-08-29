import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class A273278 {

    static class SegmentTree{
        static class Data{
            long sum;
            long pref;
            long suf;
            long res;
            Data(long sum, long pref, long suf, long res){
                this.sum = sum;
                this.pref = pref;
                this.suf = suf;
                this.res = res;
            }
            public String toString() {
                return "sum: "+sum+" pref: "+pref+" suf: "+suf+" res: "+res;
            }
        }

        static Data seg[];
        static int a[]; // 0 based

        SegmentTree(){
            seg = new Data[405000];
            a = new int[205000];
        }

        Data combine(Data a, Data b){
            Data res = new Data(0,0,0,0);
            res.sum = a.sum + b.sum;
            res.pref = Math.max(a.pref, a.sum + b.pref);
            res.suf = Math.max(a.suf + b.sum, b.suf);
            res.res = Math.max(Math.max(a.res, b.res), a.suf + b.pref);
            return res;
        }

        //Seg.build(1, 0, a.length - 1);
        void build(int v, int l, int r){
            if (l == r){
                seg[v] = new Data(a[l], a[l], a[l], a[l]);
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
                seg[v] = new Data(new_val, new_val, new_val, new_val);
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
        Data query(int v, int tl, int tr, int l, int r) {
            if (l > r)
                return new Data(0,0,0,0);
            if (l == tl && r == tr) {
                return seg[v];
            }
            int tm = (tl + tr) / 2;
            return combine(query(v*2, tl, tm, l, Math.min(r, tm))
                    , query(v*2+1, tm+1, tr, Math.max(l, tm+1), r));
        }
    }



    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        SegmentTree Seg = new SegmentTree();
        for (int i=0;i<n;++i){
            Seg.a[i] = fs.nextInt();
        }
        Seg.build(1, 0, n-1);
        long res = Seg.query(1, 0, n - 1, 0, n - 1).res;
        System.out.println(Math.max(res, 0));
        for (int i=0;i<m;++i){
            int x = fs.nextInt(), y = fs.nextInt();
            Seg.update(1, 0, n - 1, x, y);
            res = Seg.query(1, 0, n - 1, 0, n - 1).res;
            System.out.println(Math.max(res, 0));
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
