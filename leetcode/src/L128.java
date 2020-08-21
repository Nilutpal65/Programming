import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class L128 {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> M = new HashMap<>();
        for (int i=0;i<nums.length;++i){
            M.put(nums[i], true);
        }
        int ans = 0;
        for (int i=0;i<nums.length;++i) if (M.get(nums[i])) {
            int cnt = 1 ;
            M.put(nums[i], false);
            int j = nums[i]-1;
            while (M.containsKey(j) && M.get(j)) {
                cnt++;
                M.put(j, false);
                --j;
            }

            j = nums[i]+1;
            while (M.containsKey(j) && M.get(j)) {
                cnt++;
                M.put(j, false);
                ++j;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().trim().split(" ");
    }
}
