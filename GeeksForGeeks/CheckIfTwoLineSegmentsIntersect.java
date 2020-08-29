import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckIfTwoLineSegmentsIntersect {

    static int orientation(int x1, int y1, int x2, int y2, int x3, int y3){
        long res1 = (x3 - x2) * (y2 - y1) * 1L;
        long res2 = (x2 - x1) * (y3 - y2) * 1L;
        if (res1 == res2) return 0; //colinear
        else if (res1 < res2) return 1; //clockwise
        else return 2; //anti-clockwise
    }

    static boolean liesOnSegment(int x1, int y1, int x2, int y2, int x3, int y3){
        if ((x2>=Math.min(x1, x3) && x2<=Math.max(x1, x3)) && (y2>=Math.min(y1, y3) && y2<=Math.max(y1, y3))) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        //System.out.println(orientation(0,0, 4, 4, 5, 3));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String in[] = br.readLine().trim().split(" ");
            int x1 = Integer.parseInt(in[0]);
            int y1 = Integer.parseInt(in[1]);
            int x2 = Integer.parseInt(in[2]);
            int y2 = Integer.parseInt(in[3]);

            in = br.readLine().trim().split(" ");
            int x3 = Integer.parseInt(in[0]);
            int y3 = Integer.parseInt(in[1]);
            int x4 = Integer.parseInt(in[2]);
            int y4 = Integer.parseInt(in[3]);

            boolean canIntersect = false;

            int o1 = orientation(x1, y1, x2, y2, x3, y3);
            int o2 = orientation(x1, y1, x2, y2, x4, y4);
            int o3 = orientation(x3, y3, x4, y4, x1, y1);
            int o4 = orientation(x3, y3, x4, y4, x2, y2);

            if (o1!=o2 && o3!=o4) canIntersect = true;

            if (o1==0 && liesOnSegment(x1, y1, x3, y3, x2, y2)) canIntersect = true;
            if (o2==0 && liesOnSegment(x1, y1, x4, y4, x2, y2)) canIntersect = true;
            if (o3==0 && liesOnSegment(x3, y3, x1, y1, x4, y4)) canIntersect = true;
            if (o4==0 && liesOnSegment(x3, y3, x2, y2, x4, y4)) canIntersect = true;

            if (canIntersect) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
