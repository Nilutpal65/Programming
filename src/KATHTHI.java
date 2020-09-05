import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KATHTHI {
    static class Pair{
        int i;
        int j;
        int distance;
        Pair(int i, int j, int distance){
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }
    static boolean isPossible(int x, int y, int i, int j){
        if (x>=0 && x<i && y>=0 && y<j) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int test = fs.nextInt();
        while (test-- > 0) {
            int n = fs.nextInt(), m = fs.nextInt();
            char c[][] = new char[n][m];
            int vis[][] = new int[n][m];
            for (int i=0;i<n;++i) {
                String s = fs.next();
                for (int j=0;j<m;++j) c[i][j] = s.charAt(j);
            }
            Deque<Pair>D = new LinkedList<>();
            D.push(new Pair(0,0, 0));
            while (!D.isEmpty()){
                Pair front = D.getFirst();
                if (front.i == n-1 && front.j == m-1) {
                    System.out.println(front.distance);
                    break;
                }
                D.pollFirst();
                vis[front.i][front.j] = 1;
                if (isPossible(front.i-1, front.j,n,m)){
                    if (vis[front.i-1][front.j] == 0) {
                        if (c[front.i][front.j] == c[front.i-1][front.j]){
                            D.addFirst(new Pair(front.i-1, front.j,front.distance));
                        } else {
                            D.addLast(new Pair(front.i-1, front.j,front.distance+1));
                        }
                    }
                }
                if (isPossible(front.i+1, front.j,n,m)){
                    if (vis[front.i+1][front.j] == 0) {
                        if (c[front.i][front.j] == c[front.i+1][front.j]){
                            D.addFirst(new Pair(front.i+1, front.j,front.distance));
                        } else {
                            D.addLast(new Pair(front.i+1, front.j,front.distance+1));
                        }
                    }
                }
                if (isPossible(front.i, front.j-1,n,m)){
                    if (vis[front.i][front.j-1] == 0) {
                        if (c[front.i][front.j] == c[front.i][front.j-1]){
                            D.addFirst(new Pair(front.i, front.j-1,front.distance));
                        } else {
                            D.addLast(new Pair(front.i, front.j-1,front.distance+1));
                        }
                    }
                }
                if (isPossible(front.i, front.j+1,n,m)){
                    if (vis[front.i][front.j+1] == 0) {
                        if (c[front.i][front.j] == c[front.i][front.j+1]){
                            D.addFirst(new Pair(front.i, front.j+1,front.distance));
                        } else {
                            D.addLast(new Pair(front.i, front.j+1,front.distance+1));
                        }
                    }
                }
            }
            //System.out.println(res);
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
