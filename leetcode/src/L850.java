import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class L850 {
    static long mod = 1000000007L;
    static class Pair {
        int x;
        int y;
        boolean start;
        Pair(int x, int y, boolean start){
            this.x = x;
            this.y = y;
            this.start = start;
        }
    }
    static int rectangleArea(int[][] rectangles) {
        int len = rectangles.length;
        List<Pair>points = new ArrayList<>();
        Map<Pair, Pair>M = new HashMap<>();
        for (int i=0; i<len; ++i){
            Pair left = new Pair(rectangles[i][0], rectangles[i][3], true);
            Pair right = new Pair(rectangles[i][2], rectangles[i][3], false);
            points.add(left);
            points.add(right);
            M.put(right, left);
        }
        Collections.sort(points, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (o1.x == o2.x) ? (o2.y - o1.y) : (o1.x - o2.x);
            }
        });
        PriorityQueue<Pair>P = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (o1.y == o2.y) ? (o2.x - o1.x) : (o2.y - o1.y);
            }
        });
        long total = 0;
        for (Pair e:points){
            //System.out.println(e.x + " "  + e.y);
            if (e.start){
                if (!P.isEmpty()){
                    Pair top = P.peek();
                    if (e.y >= top.y || e.x > top.x){
                        long res = ((long) Math.min(e.y, top.y) * (long)Math.abs(e.x - top.x) * 1L) % mod;
                        total += res;
                    }
                }
                P.add(e);
            } else {
                if (!P.isEmpty()){
                    Pair top = P.peek();
                    if (e.y >= top.y || e.x > top.x){
                        long res = ((long) Math.min(e.y, top.y) * (long)Math.abs(e.x - top.x) * 1L) % mod;
                        total += res;
                    }
                }
                P.add(e);
//                P.remove(e);
//                if (M.containsKey(e)){
//                    P.remove(M.get(e));
//                }
            }
            total %= mod;
        }
        return (int)total;
    }
    public static void main(String[] args) throws IOException {
        //System.out.println(rectangleArea(new int[][]{{0,0,2,2},{1,0,2,3},{1,0,3,1}}));
        //System.out.println(rectangleArea(new int[][]{{0,0,1,1},{2,2,3,3}}));
        //long res = (1000000000L * 1000000000L) % mod;
        //System.out.println(res);
    }
}
