import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class L850 {
    static long mod = 1000000007L;
    static class Pair {
        int x;
        int index;
        int y1;
        int y2;
        boolean start;
        Pair(int index, int x, int y1, int y2, boolean start){
            this.index = index;
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
            this.start = start;
        }
    }
    static int rectangleArea(int[][] rectangles) {
        int n = rectangles.length;
        List<Pair>L = new ArrayList<>();
        for (int i=0;i<n;++i){
            int x1 = rectangles[i][0], y1 = rectangles[i][1], x2 = rectangles[i][2], y2 = rectangles[i][3];
            L.add(new Pair(i, x1, y1, y2, true));
            L.add(new Pair(i, x2, y1, y2, false));
        }
        Collections.sort(L, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.x == o2.x){
                    if (o1.start != o2.start){
                        if (!o1.start) return -1;
                        else return 1;
                    }
                }
                return o1.x - o2.x;
            }
        });
        TreeSet<Pair> T = new TreeSet<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.y1 == o2.y1){
                    if (o1.y2 == o2.y2) return o1.index - o2.index;
                    else return o1.y2 - o2.y2;
                } else {
                    return o1.y1 - o2.y1;
                }
            }
        });

        int prevx = 0;
        long res = 0;

        for (Pair e:L) {
            int currentX = e.x;
            long width = currentX - prevx;
            long height = getHeight(T);
            if (e.start) {
                T.add(e);
            } else {
                for (Pair f:T) {
                    if (f.index == e.index) {
                        T.remove(f);
                        break;
                    }
                }
            }
            prevx = currentX;
            res = (res + (width * height) % mod) % mod;
        }
        return  (int)res;
    }

    static long getHeight(TreeSet<Pair> T) {
        long res = 0;
        int startPrev = 0;
        int endPrev = 0;
        for (Pair e:T) {
            int startCur = e.y1; int endCur = e.y2;
            if (startCur <= endPrev) {
                endPrev = Math.max(endPrev, endCur);
            } else {
                res = (res + (long)(endPrev - startPrev) % mod) % mod;
                startPrev = startCur;
                endPrev = endCur;
            }
        }
        res = (res + (long)(endPrev - startPrev) % mod) % mod;
        return res;
    }

    public static void main(String[] args) throws IOException {
        //System.out.println(rectangleArea(new int[][]{{0,0,2,2},{1,0,2,3},{1,0,3,1}}));
        //System.out.println(rectangleArea(new int[][]{{0,0,1,1},{2,2,3,3}}));
        //long res = (1000000000L * 1000000000L) % mod;
        //System.out.println(res);
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
