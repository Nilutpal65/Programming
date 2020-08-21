import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TestClass {
    static class Pair implements Comparable<Pair>{
        String s;
        long v;
        Pair(long v, String s){
            this.s = s;
            this.v = v;
        }
        Long getLong(){
            return this.v;
        }
        public int compareTo(Pair o){
            return this.getLong().compareTo(o.v);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String in[] = br.readLine().trim().split(" ");

        String a[] = br.readLine().trim().split(",");
        int n = a.length;
        Set<String>S = new HashSet<>();
        String b[] = new String[n+1];
        int c[] = new int[n+1];
        //int ans[] = new int[n+1];
        String d[] = new String[n+1];
        Map<String,String>child = new HashMap<>();
        Map<String,Long>ans = new HashMap<>();
        //Map<String,Long>ans1 = new HashMap<>();
        for (int i=0;i<n-1;++i){
            String x[] = br.readLine().trim().split(" ");
            b[i] = x[0];
            c[i] = Integer.parseInt(x[2]);
            d[i] = x[3];
            child.put(b[i], d[i]);
            S.add(x[0]);
            //System.out.println(b[i] + " " + c[i] + " " + d[i]);
        }
        String lowest = null;
        for (int i=0;i<n;++i){
            if(!S.contains(a[i])){
                lowest = a[i];
                ans.put(lowest, 1L);
            }
        }
        //System.out.println(lowest);
        if (lowest!=null){
            for (int i=0;i<n;++i){
                for (int j=0;j<n-1;++j){
                    if (ans.containsKey(d[j])){
                        ans.put(b[j], c[j]*1L*ans.get(d[j]));
                    }
                }
            }

            long mx = 0;

            for (int i=0;i<n;++i){
                //System.out.println(ans.get(a[i]));
                mx = Math.max(ans.get(a[i]), mx);
            }
            List<Pair>L = new ArrayList<>();
            for (int i=0;i<n;++i) {
                long res = (mx / ans.get(a[i]));
                L.add(new Pair(res, a[i]));
                //System.out.println(res + " " + a[i]);
            }
            Collections.sort(L);
            //L.sort((o1, o2) -> o2.compareTo(o1));
            for (Pair e:L){
                if (!e.s.equals(lowest)){
                    System.out.print(e.v+e.s + " = ");
                }
            }
            Pair last = L.get(L.size()-1);
            System.out.println(last.v+last.s);
        }
    }
}
