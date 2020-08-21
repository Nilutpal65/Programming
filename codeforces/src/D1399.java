import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D1399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int ans[] = new int[n];

            int cnt0=0;
            int cnt1=0;

            List<Integer> pos0 = new ArrayList<>();
            List<Integer> pos1 = new ArrayList<>();

            int mx = 0;

            for (int i=0;i<n;++i) {
                int npos = pos0.size() + pos1.size();
                if (s.charAt(i) == '1'){
                    if (pos0.size() == 0){
                        pos1.add(npos);
                    } else {
                        int lastIndex = pos0.size() - 1;
                        npos = pos0.get(lastIndex);
                        pos0.remove(lastIndex);
                        pos1.add(npos);
                    }
                } else {
                    if (pos1.size() == 0){
                        pos0.add(npos);
                    } else {
                        int lastIndex = pos1.size() - 1;
                        npos = pos1.get(lastIndex);
                        pos1.remove(lastIndex);
                        pos0.add(npos);
                    }
                }
                ans[i] = npos;
                mx = Math.max(npos, mx);
            }
            System.out.println(mx+1);
            for (int i=0;i<n;++i){
                System.out.print((ans[i]+1) + " ");
            }
            System.out.println("");
        }
    }
}
