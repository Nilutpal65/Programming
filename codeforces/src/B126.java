import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B126 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String in[] = br.readLine().trim().split(" ");
        String s = br.readLine();
        int n = s.length();
        int z[] = new int[n];
        int L = 0, R = 0;
        for (int i = 1; i < n; i++) {
            if (i > R) {
                L = R = i;
                while (R < n && s.charAt(R-L) == s.charAt(R)) R++;
                z[i] = R-L; R--;
            } else {
                int k = i-L;
                if (z[k] < R-i+1) z[i] = z[k];
                else {
                    L = i;
                    while (R < n && s.charAt(R-L) == s.charAt(R)) R++;
                    z[i] = R-L; R--;
                }
            }
        }
        int ans=0;
        int mx = 0;
        int count[] = new int[n];
        Arrays.fill(count, 0);
        ArrayList<Integer> mem = new ArrayList<>();
        for (int i=1;i<n;++i){
            mx = Math.max(mx, z[i]);
            count[z[i]]++;
            if (z[i]+i == n) {
                mem.add(z[i]);
            }
        }
        Collections.sort(mem, Comparator.reverseOrder());
        if(mem.size()<2){
            if (mem.size() == 1){
                if ((count[mem.get(0)]>1) || (mem.get(0)<mx)){
                    String sub = s.substring(0, mem.get(0));
                    System.out.println(sub);
                } else {
                    System.out.println("Just a legend");
                }
            } else {
                if (mem.size()>0 && mem.get(0)<mx){
                    String sub = s.substring(0, ans);
                    System.out.println(sub);
                } else {
                    System.out.println("Just a legend");
                }
            }

        } else {
            if ((mem.get(0)<mx) || (count[mem.get(0)] > 1)) {
                ans = mem.get(0);
            } else {
                ans = mem.get(1);
            }
            String sub = s.substring(0, ans);
            System.out.println(sub);
        }

//        for (int k=0;k<n;++k){
//            System.out.print(z[k] + " ");
//        }
    }
}
//
//a b c a b d
//0 0 0 1 2 0
