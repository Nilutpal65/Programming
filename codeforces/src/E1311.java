import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E1311 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){

            String in[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(in[0]);
            int m = Integer.parseInt(in[1]);

            int sz[] = new int[Math.max(n+1, 15)];
            Arrays.fill(sz, 2);

            for (int i=0;i<=13;++i){
                sz[i+1] = 1<<i;
            }

            int sz1[] = new int[Math.max(n+1, 15)];
            Arrays.fill(sz1,1);
            int tot = n * (n-1) /2 ;
            int end = n;

            while (tot>m){
                int cur = end - 1;
                while (true){
                    if (cur<0){
                        break;
                    }
                    if (sz1[cur]+1<=sz[cur] && tot>m){
                        sz1[cur]++;
                        sz1[cur+1]--;
                    } else {
                        break;
                    }
                    --cur;
                    --tot;
                }
                if (cur<0){
                    break;
                }
                --end;
            }

            int cnt = 2;
            if (tot == m && sz1[1]>0){
                System.out.println("YES");
                List<Integer>L[] = new ArrayList[5000];
                List<Integer>P[] = new ArrayList[5000];

                int last = 2;
                L[1] = new ArrayList<>();
                L[1].add(1);
                for (int i=2;i<=n;++i){
                    L[i] = new ArrayList<>();
                    P[i] = new ArrayList<>();
                    if (sz1[i]>0){
                        for (int j=1;j<=sz1[i]; ++j){
                            L[i].add(cnt++);
                        }
                    } else {
                        last = i;
                        break;
                    }
                }

                int tot1 = (n * (n-1))/2;
                if(tot1 == m){
                    last = n;
                }

                L[last+1] = new ArrayList<>();
                P[last+1] = new ArrayList<>();

                for (int i=1;i<=last;++i){
                    if (L[i].size() > 0) {
                        for (int j=0;j<L[i].size();++j){
                            int cur = L[i].get(j);
                            if (L[i+1].size()>(j*2)){
                                P[i+1].add(cur);
                            }
                            if (L[i+1].size()>(j*2+1)){
                                P[i+1].add(cur);
                            }
                        }
                    }
                }

                for (int i=2;i<=last;++i){
                    if (P[i].size() > 0)
                    for (Integer e:P[i]){
                        System.out.print(e + " ");
                    }
                }

                System.out.println("");
            } else {
                System.out.println("NO");
            }
        }
    }
}
