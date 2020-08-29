import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E1401 {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int nh = fs.nextInt();
        int nv = fs.nextInt();
        ArrayList<Event> events = new ArrayList<>();
        for (int i=0;i<nh;++i){
            int y = fs.nextInt(), x1 = fs.nextInt(), x2 = fs.nextInt();
            if (x2 == 1_000_000) x2++;
            events.add(new Event(x1, 1, y, y));
            events.add(new Event(x2, -1, y, y));
        }
        for (int i=0;i<nv;++i){
            int x = fs.nextInt(), y1 = fs.nextInt(), y2 = fs.nextInt();
            events.add(new Event(x, 0, y1, y2));
        }
        events.add(new Event(1_000_000, 0, 0, 1_000_000));
        Collections.sort(events);
//        for (Event e:events){
//            System.out.println(e.toString());
//        }
        TreeSet<Integer>endpoints = new TreeSet<>();
        BIT bit = new BIT(1_000_001);
        bit.update(0,1 );
        bit.update(1_000_000, 1);
        long parts = 0;
        for (Event e:events){
            System.out.println("Processing "+e);
            if (e.delta == 1){
                if (e.x == 0){
                    bit.update(e.y1,1 );
                } else {
                    endpoints.add(e.y1);
                }
            } else if(e.delta == -1){
                bit.update(e.y1, -1);
            } else {
                int nIntersect = bit.rangeSum(e.y1, e.y2);
                parts += nIntersect - 1;
                System.out.println("  Intersect "+nIntersect);
                if (e.y1 == 0){
                    while (!endpoints.isEmpty() && endpoints.first()<=e.y2){
                        int first  = endpoints.first();
                        endpoints.remove(first);
                        bit.update(first, 1);
                    }
                } else {
                    while (!endpoints.isEmpty() && endpoints.last()>=e.y1){
                        int last = endpoints.last();
                        endpoints.remove(last);
                        bit.update(last, 1);
                    }
                }
            }
        }
        System.out.println(parts);
    }


    static class Event implements Comparable<Event>{
        int x;
        int delta;
        int y1;
        int y2;

        Event(int x, int delta, int y1, int y2){
            this.x = x;
            this.delta = delta;
            this.y1 = y1;
            this.y2 = y2;
        }

        @Override
        public int compareTo(Event o) {
            if (x!=o.x) return Integer.compare(x, o.x);
            return -Integer.compare(delta, o.delta);
        }

        public String toString() {
            return "x: "+x+" y1: "+y1+" y2: "+y2+" delta: "+delta;
        }
    }

    static class BIT { //Binary Index Tree
        int n;
        int []tree;
        BIT(int n){
            this.n = n;
            this.tree = new int[n+2];
        }
        int read(int i){
            i++;
            int sum = 0;
            while (i>0){
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
        int rangeSum(int from, int to) {
            return read(to)-read(from-1);
        }
        void update(int i, int val){
            ++i;
            while (i<=n){
                tree[i] += val;
                i += i & -i;
            }
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
