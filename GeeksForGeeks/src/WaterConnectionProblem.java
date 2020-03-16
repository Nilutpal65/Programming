import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
public class WaterConnectionProblem {
    static class Point {
        int U;
        int V;
        int D;
        Point() {
            U=0;
            V=0;
            D=0;
        }
    }
    static ArrayList<Point>[]gr;
    static int parent[];
    static int end = 0;
    static int mn =  0;
    static void dfs(int v, int min) {
        for (Point p:gr[v]) {
            end = p.V;
            mn = min;
            dfs(end, Math.min(min, p.D));
        }
    }

    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String np[] = br.readLine().split(" ");
            int N = Integer.parseInt(np[0]);
            int P = Integer.parseInt(np[1]);
            gr = new ArrayList[N+1];
            parent = new int[N+1];
            Arrays.fill(parent, -1);
        }
    }
}
