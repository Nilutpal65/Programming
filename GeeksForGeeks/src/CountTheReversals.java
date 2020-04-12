import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;

public class CountTheReversals {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            String s = br.readLine();
            Stack<Character> st = new Stack<>();
            for (int i=0;i<s.length();++i) {
                if (s.charAt(i) == '{') {
                    st.add(s.charAt(i));
                } else {
                    if (!st.empty()) {
                        if (st.peek() == '{') {
                            st.pop();
                        } else {
                            st.add(s.charAt(i));
                        }
                    } else {
                        st.add(s.charAt(i));
                    }
                }
            }
            double left = 0 ;
            double right = 0 ;
            int ans = -1 ;
            while (!st.empty()) {
                if (st.peek() == '{') left++;
                else right++;
                st.pop();
            }
            if ((left + right) % 2 == 0) {
                ans = (int)Math.ceil(left/2) + (int)Math.ceil(right/2);
            }
            System.out.println(ans);
        }
    }
}
