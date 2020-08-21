import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SumOfFourNumber {
    static class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    static class Ans{
        int a;
        int b;
        int c;
        int d;
        Ans(int a, int b, int c, int d){
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        public int hashCode(){
            final int temp = 14;
            final int temp2 = 212;
            final int temp3 = 33;
            final int temp4 =443;
            int ans = 1;
            ans = (temp*a) + (temp2*b) + (temp3*c) + (temp4*d);
            return ans;
        }
        public boolean equals(Object o)
        {
            if (this == o) {
                return true;
            }
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            Ans other = (Ans) o;
            if (this.a != other.a) {
                return false;
            }
            if (this.b != other.b) {
                return false;
            }
            if (this.c != other.c) {
                return false;
            }
            if (this.d != other.d) {
                return false;
            }
            return true;
        }
    }
    static List<Pair>L[] = new ArrayList[2001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n, k;
            String in[] = br.readLine().trim().split(" ");
            n = Integer.parseInt(in[0]);
            k = Integer.parseInt(in[1]);
            in = br.readLine().trim().split(" ");
            int a[] = new int[n];
            for (int i=0;i<n;++i){
                a[i] = Integer.parseInt(in[i]);
            }
            Arrays.sort(a);
            int cnt = 0;
            Map<Integer, Integer>M = new HashMap<>();
            for (int i=0;i<2001;++i){
                L[i] = new ArrayList<>();
            }
            for (int i=0;i<n;++i){
                for (int j=i+1;j<n;++j){
                    if (M.containsKey(a[i]+a[j])){
                        if (!L[M.get(a[i]+a[j])].contains(new Pair(i,j))){
                            L[M.get(a[i]+a[j])].add(new Pair(i,j));
                        }
                    } else {
                        M.put(a[i]+a[j], cnt++);
                        L[M.get(a[i]+a[j])].add(new Pair(i,j));
                    }
                }
            }
            List<Ans>A = new ArrayList<>();
            Map<Ans, Boolean>Ma = new HashMap<>();
            for (int i=0;i<n;++i){
                for (int j=i+1;j<n;++j){
                    int res =  k - (a[i]+a[j]);
                    if (M.containsKey(res)) {
                        List<Pair> T = L[M.get(res)];
                        T.remove(new Pair(i,j));
                        for (Pair e:T){
                            if ((e.a!=i) && (e.b!=j) && (e.a!=j) && (e.b!=i) && (e.a>=j)){
                                if (!Ma.containsKey(new Ans(a[i],a[j],a[e.a],a[e.b]))){
                                    Ma.put(new Ans(a[i],a[j],a[e.a],a[e.b]), true);
                                    A.add(new Ans(a[i],a[j],a[e.a],a[e.b]));
                                }
                            }
                        }
                    }
                }
            }
            for (Ans e:A){
                System.out.print(e.a + " " + e.b + " " + e.c + " " + e.d + " $");
            }
            if (A.size() == 0) {
                System.out.print("-1");
            }
            System.out.println("");
        }
    }
}
