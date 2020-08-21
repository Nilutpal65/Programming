import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MaximumRectangularAreaHistogram {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            String in[] = br.readLine().trim().split(" ");
            long a[] = new long[n];
            Stack<Integer>s = new Stack<>();
            for (int i=0;i<n;++i){
                a[i] = Long.parseLong(in[i]);
            }
            int i = 0;
            long ans = 0;
            while (i<n){
                if (s.empty()){
                    s.push(i);
                    ++i;
                } else if(a[s.peek()]<=a[i]){
                    s.push(i);
                    ++i;
                } else {
                    int top = s.peek();
                    s.pop();
                    long res = a[top] * ((s.empty())?i:(i-s.peek()-1));
                    ans = Math.max(ans, res);
                }
            }
            while (!s.empty()){
                int top = s.peek();
                s.pop();
                long res = a[top] * ((s.empty())?i:(i-s.peek()-1));
                ans = Math.max(ans, res);
            }
            System.out.println(ans);
        }
    }
}
