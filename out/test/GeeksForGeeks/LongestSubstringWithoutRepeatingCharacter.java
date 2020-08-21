import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt[] = new int[30];
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            String s = br.readLine();
            Arrays.fill(cnt, 0);
            Set<Character> so = new HashSet<>();
            int front = 0;
            int end = 0;
            int ans = 0;
            while(front<s.length()){
                if (cnt[s.charAt(front)-'a'] > 0){
                    while((s.charAt(end) != s.charAt(front)) && (end<front)) {
                        cnt[s.charAt(end)-'a']--;
                        if(cnt[s.charAt(end)-'a'] == 0) {
                            so.remove(s.charAt(end));
                        }
                        ++end;
                    }
                    if ((s.charAt(end) == s.charAt(front)) && (end!=front)){
                        cnt[s.charAt(end)-'a']--;
                        if(cnt[s.charAt(end)-'a'] == 0) {
                            so.remove(s.charAt(end));
                        }
                        ++end;
                    }
                    cnt[s.charAt(front)-'a']++;
                    so.add(s.charAt(front));
                    front++;
                    ans = Math.max(so.size(), ans);
                } else {
                    cnt[s.charAt(front)-'a']++;
                    so.add(s.charAt(front));
                    front++;
                    ans = Math.max(so.size(), ans);
                }
            }
            System.out.println(ans);
        }
    }
}
