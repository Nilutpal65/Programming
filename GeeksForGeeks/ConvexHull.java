import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConvexHull {
    static class Points{
        int x,y;
        Points(int x, int y){
            this.x = x; this.y = y;
        }
        public String toString(){
            return x + " " + y;
        }
    }
    static int orientation(Points x, Points y, Points z){
        int o1 = (y.y - x.y) * (z.x - y.x);
        int o2 = (z.y - y.y) * (y.x - x.x);
        if (o1 == o2) return 0;
        if (o1 > o2) return 1;
        else return -1;
    }
    static int distance(Points x, Points y){
        return (int)Math.pow(y.y - x.y, 2) + (int)Math.pow(y.x - x.x, 2);
    }
    public static void main(String[] args) throws IOException {
        System.out.println(orientation(new Points(30,48), new Points(39,48), new Points(45,3)));
        FastScanner fs = new FastScanner();
        int test = fs.nextInt();
        while (test-- > 0){
            int n = fs.nextInt();
            List<Points>L = new ArrayList<>();
            TreeSet<Points>Tr = new TreeSet<>(new Comparator<Points>() {
                @Override
                public int compare(Points o1, Points o2) {
                    return (o1.y == o2.y) ? o1.x - o2.x : o1.y - o2.y;
                }
            });
            for (int i=0;i<n;++i){
                int x= fs.nextInt(), y = fs.nextInt();
                Tr.add(new Points(x,y));
                //L.add(new Points(x,y));
            }
            //System.out.println(Tr);
            for (Points e:Tr){
                L.add(e);
            }
            Collections.sort(L, new Comparator<Points>() {
                @Override
                public int compare(Points o1, Points o2) {
                    return (o1.y == o2.y) ? o1.x - o2.x : o1.y - o2.y;
                }
            });
            Points first = L.get(0);
            L.remove(first);
            Collections.sort(L, new Comparator<Points>() {
                @Override
                public int compare(Points o1, Points o2) {
                    int orient = orientation(first, o1, o2);
                    if (orient == 0) {
                        if (distance(first, o1) > distance(first, o2)) return 1;
                        else return -1;
                    }
                    return orient;
                }
            });
            Stack<Points>S = new Stack<>();
            S.add(first);
            if (L.size() > 0){
                Points res = L.get(0);
                S.add(res);
                L.remove(res);
            }
            if (L.size() > 0){
                Points res = L.get(0);
                S.add(res);
                L.remove(res);
            }
            if (S.size() < 3) {
                System.out.println(-1);
                continue;
            } else {
                while (L.size() > 0) {

                    while (S.size() > 2){
                        int last = S.size() - 1 ;
                        Points f = S.get(last);
                        Points s = S.get(last-1);
                        Points t = S.get(last-2);
                        if (orientation(t,s,f) > 0) {
                            Points r = S.peek();
                            S.pop();
                            S.pop();
                            S.add(r);
                        } else {
                            break;
                        }
                    }
                    S.add(L.get(0));
                    L.remove(0);
                }
            }
            List<Points> LL = new ArrayList<>();
            while (S.size() > 2){
                int last = S.size() - 1 ;
                Points f = S.get(last);
                Points s = S.get(last-1);
                Points t = S.get(last-2);
                if (orientation(t,s,f) > 0) {
                    Points r = S.peek();
                    S.pop();
                    S.pop();
                    S.add(r);
                } else {
                    LL.add(S.peek());
                    S.pop();
                    break;
                }
            }

            while (!S.isEmpty()){
                LL.add(S.peek()); S.pop();
            }

            Collections.sort(LL, new Comparator<Points>() {
                @Override
                public int compare(Points o1, Points o2) {
                    return (o1.x == o2.x) ? o1.y - o2.y : o1.x - o2.x;
                }
            });
            for (int i=0;i<LL.size();++i){
                System.out.print(LL.get(i));
                if (i<LL.size()-1){
                    System.out.print(", ");
                }
            }
            System.out.println("");
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
/**
1
9
0 0 1 0 2 0 3 2 4 4 1 4 0 3 -1 3 1 1
 */
