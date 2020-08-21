import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RearrangeChanracter {
    static class Pair{
        int key;
        int value;
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String in[] = br.readLine().trim().split(" ");
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String s = br.readLine();
            int fre[] = new int[30];
            Arrays.fill(fre, 0);
            List<Character>L = new ArrayList<>();
            for (int i=0;i<s.length();++i){
                L.add(s.charAt(i));
                fre[s.charAt(i)-'a']++;
            }
            PriorityQueue<Pair>Mx = new PriorityQueue<>(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o2.value - o1.value;
                }
            });
            for (int i=0;i<26;++i){
                if (fre[i]>0){
                    Mx.add(new Pair(i, fre[i]));
                }
            }
            //String ans = "";
            int prev = -1;
            boolean noans = false;
            while (!Mx.isEmpty()){
                Pair p1 = Mx.peek();
                Mx.poll();
                if (p1.key == prev){
                    if (!Mx.isEmpty()){
                        Pair p2 = Mx.peek();
                        Mx.poll();
                        //ans += (char)(p2.key+'a');
                        if (p2.value>1){
                            Mx.add(new Pair(p2.key, p2.value-1));
                        }
                        Mx.add(new Pair(p1.key, p1.value));
                        prev = p2.key;
                    } else {
                        noans = true;
                        break;
                    }
                } else {
                    prev = p1.key;
                    //ans += (char)(p1.key+'a');
                    if (p1.value > 1){
                        Mx.add(new Pair(p1.key, p1.value-1));
                    }
                }
            }
            //System.out.println(ans);
            if (!noans){
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
