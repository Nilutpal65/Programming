import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1393 {
    static class Pair{
        int f;
        int s;
        Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        String in[] = br.readLine().trim().split(" ");


        Map<Integer, Integer> M = new HashMap<>();

        Set<Integer>two = new HashSet<>();
        Set<Integer>four = new HashSet<>();
        Set<Integer>six = new HashSet<>();
        Set<Integer>eight = new HashSet<>();

        for (int i=0;i<n;++i){
            a[i] = Integer.parseInt(in[i]);
            if (M.containsKey(a[i])){
                M.put(a[i], M.get(a[i]) + 1);
            } else {
                M.put(a[i], 1);
            }
            if (M.get(a[i]) == 2){
                two.add(a[i]);
            }
            if (M.get(a[i]) == 4){
                two.remove(a[i]);
                four.add(a[i]);
            }
            if (M.get(a[i]) == 6){
                four.remove(a[i]);
                six.add(a[i]);
            }
            if (M.get(a[i]) == 8){
                six.remove(a[i]);
                eight.add(a[i]);
            }
        }

        int q = Integer.parseInt(br.readLine());

        while (q-- > 0){
            in = br.readLine().trim().split(" ");
            int x = Integer.parseInt(in[1]);
            if (in[0].charAt(0) == '+'){
                if (M.containsKey(x)){
                    M.put(x, M.get(x) + 1);
                } else {
                    M.put(x, 1);
                }

                if (M.get(x) == 2){
                    two.add(x);
                }
                if (M.get(x) == 4){
                    two.remove(x);
                    four.add(x);
                }
                if (M.get(x) == 6){
                    four.remove(x);
                    six.add(x);
                }
                if (M.get(x) == 8){
                    six.remove(x);
                    eight.add(x);
                }

            } else {
                if (M.containsKey(x)){
                    M.put(x, M.get(x) - 1);
                }
                if(M.get(x) < 2){
                    if(two.contains(x)){
                        two.remove(x);
                    }
                }
                if (M.get(x) >= 2 && M.get(x) < 4){
                    if (four.contains(x)){
                        four.remove(x);
                    }
                    two.add(x);
                }
                if (M.get(x) >= 4 && M.get(x) < 6){
                    if (six.contains(x)){
                        six.remove(x);
                    }
                    four.add(x);
                }
                if (M.get(x) >= 6 && M.get(x) < 8){
                    if (eight.contains(x)){
                        eight.remove(x);
                    }
                    six.add(x);
                }
                if (M.get(x) == 8){
                    eight.add(x);
                }
            }

            boolean condition = false;
            if (eight.size() > 0){
                condition = true;
            } else if (six.size() > 1){
                condition = true;
            } else if (six.size()>0 && four.size()>0){
                condition = true;
            } else if (six.size()>0 && two.size()>0){
                condition = true;
            } else if (four.size()>1){
                condition = true;
            } else if (four.size()>0 && two.size()>1){
                condition = true;
            }

            if (condition) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
