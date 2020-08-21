import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B559 {
    // https://codeforces.com/problemset/problem/559/B


    static String smallest(String s) {
        if (s.length() % 2 == 1) return s;
        String s1 = smallest(s.substring(0, s.length()/2));
        String s2 = smallest(s.substring(s.length()/2));
        if (s1.compareTo(s2)<1) return s1 + s2;
        else return s2 + s1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine().trim();
        String b = br.readLine().trim();

        //System.out.println(smallest(a));

        if(smallest(a).equals(smallest(b))){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
