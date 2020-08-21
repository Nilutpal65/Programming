import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String in[] = br.readLine().trim().split(" ");
        int a[] = new int[n];
        for (int i=0;i<n;++i) {
            a[i] = Integer.parseInt(in[i]);
        }
        int left = 0;
        int right = n-1;
        Set<Integer> s = new HashSet<>();
        while (left<=right){
            boolean added = false;
            if (!s.contains(a[left])){
                added = true;
                s.add(a[left++]);
            } else {
                if (!s.contains(a[right])){
                    added = true;
                    s.add(a[right--]);
                }
            }
            if (!added){
                break;
            }
        }
        int ans = n - s.size();
        left = 0;
        right = n-1;
        s.clear();
        while (left<=right){
            boolean added = false;
            if (!s.contains(a[right])){
                added = true;
                s.add(a[right--]);
            } else {
                if (!s.contains(a[left])){
                    added = true;
                    s.add(a[left++]);
                }
            }
            if (!added){
                break;
            }
        }
        ans = Math.min(ans, n - s.size());
        System.out.println(ans);
    }
}
