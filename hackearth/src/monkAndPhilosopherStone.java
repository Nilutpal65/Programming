import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Stack;

public class monkAndPhilosopherStone {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,k,q,sum;
        n = Integer.parseInt(br.readLine());
        int a[] = new int[n+1];
        String arrinput[] = br.readLine().split(" ");
        for (int i=0;i<n;++i) {
            a[i] = Integer.parseInt(arrinput[i]);
        }
        String w[] = br.readLine().split(" ");
        q = Integer.parseInt(w[0]);
        sum = Integer.parseInt(w[1]);
        Stack<Integer>st = new Stack<>();
        int ans = -1;
        int cur_sum = 0;
        int cur = 0;
        while (q-- > 0) {
            String s = br.readLine();
            if (s.equals("Harry")) {
                if (cur < n) {
                    st.push(a[cur]);
                    cur_sum+=a[cur];
                    ++cur;
                    if ((cur_sum == sum) && (ans == -1)) {
                        ans = st.size();
                    }
                }
            } else {
                if (!st.isEmpty()) {
                    cur_sum -= st.peek();
                    st.pop();
                    if ((cur_sum == sum) && (ans == -1)) {
                        ans = st.size();
                    }
                }
            }
        }
        System.out.println(ans);
    }
}