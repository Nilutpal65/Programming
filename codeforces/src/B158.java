import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class B158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];

        String in[] = br.readLine().trim().split(" ");

        int four=0, three=0, two=0, one=0;

        for (int i=0;i<n;++i){
            a[i] = Integer.parseInt(in[i]);
            if (a[i] == 4){
                four++;
            } else if(a[i] == 3){
                three++;
            } else if(a[i] == 2){
                two++;
            } else {
                one++;
            }
        }

        int ans = four;
        int threeone = Math.min(three, one);
        three-=threeone;
        one-=threeone;

        ans += threeone;
        if(three > 0){
            ans += three;
        }

        ans += (two/2);
        two%=2;

        ans += (one/4);
        one%=4;

        if (one>0){
            if(two>0){
                if(one<=2){
                    ans++;
                } else {
                    ans+=2;
                }
            }else {
                ans++;
            }
        } else if(two>0){
            ans++;
        }
        System.out.println(ans);
    }
}
