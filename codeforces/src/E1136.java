import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class E1136 {
    static int n;
    static long a[] = new long[200005];
    static long k[] = new long[200005];
    static long t[] = new long[200005];
    static long b[] = new long[200005];
    static long max[] = new long[400005];
    static long sum[] = new long[400005];
    static long len[] = new long[400005];
    static long add[] = new long[400005];
    static long set[] = new long[400005];
    static int q;
    static char c;
    static int u;
    static int v;

    void build(int v, int l, int r){
        if (l == r){
            max[v] = sum[v] = a[v];
            len[v] = 1;
        } else {
            int mid = l - (l - r) / 2 ;
            build(v*2, l, mid);
            build(v*2 + 1, mid+1, r);
            max[v] = Math.max(max[2*v], max[2*v+1]);
            sum[v] = sum[2*v] + sum[2*v+1];
            len[v] = r-l+1;
        }
    }

    void apply_add_mod(int v, long val){
        if (set[v]!=Integer.MIN_VALUE){
            set[v] = val;
        } else {
            add[v] += val;
        }
    }

    void apply_set_mod(int v, long val) {
        add[v] = 0;
        set[v] = val;
    }

    void push(int v) {
        if (add[v] > 0) {
            t[v] += add[v];
            sum[v] += add[v] * len[v];
            apply_add_mod(v * 2, add[v]);
            apply_add_mod(v * 2 + 1, add[v]);
            add[v] = 0;
        }
        if (set[v] != Integer.MIN_VALUE) {
            t[v] = set[v];
            sum[v] = set[v] * len[v];
            apply_set_mod(v * 2, set[v]);
            apply_set_mod(v * 2 + 1, set[v]);
            set[v] = Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String in[] = br.readLine().trim().split(" ");
        for (int i=0;i<n;++i){
            a[i] = Integer.parseInt(in[i]);
        }
        Arrays.fill(set, Integer.MIN_VALUE);
        in = br.readLine().trim().split(" ");
        for (int i=0;i<n-1;++i){
            k[i] = Integer.parseInt(in[i]);
            if (i>0) {
                t[i] = t[i-1] + k[i-1];
            }
        }
        for (int i=0;i<n-1;++i){
            b[i] = a[i] - t[i];
        }





        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            in = br.readLine().trim().split(" ");

            int l = Integer.parseInt(in[1]);
            int r = Integer.parseInt(in[2]);

            if (in[0].compareTo("s") == 0){
                int sum = 0;
                for (int i=l-1;i<=r-1;++i){
                    sum += a[i];
                }
                System.out.println(sum);
            } else {
                int i = l-1;
                a[i] += r;
                ++i;
                while (i<n){
                    if(a[i] < a[i-1]+k[i-1]){
                        a[i] = a[i-1] + k[i-1];
                    }
                    ++i;
                }
            }
        }

    }
}
