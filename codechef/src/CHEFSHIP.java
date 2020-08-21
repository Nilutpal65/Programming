import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CHEFSHIP {


    static class Hashing{
        long []hash, pow;
        long P, MOD;
        int N;

        Hashing(char str[], long P, long MOD){
            this.N = str.length; this.P=P; this.MOD = MOD;
            hash = new long[N+1]; pow = new long[N+1];
            init(str);
        }

        void init(char str[]){
            pow[0] = 1;
            for (int i=N-1;i>=0;--i){
                hash[i] = ((hash[i+1]*P)%MOD + (str[i]-'a'+1))%MOD;
                pow[N-i] = (pow[N-i-1]*P)%MOD;
            }
            pow[N]=(pow[N-1]*P)%MOD;
        }
        long getHash(){return getHash(0,N-1);}
        long getHash(int l, int r){return (MOD-(hash[r+1]*pow[r-l+1])%MOD+hash[l])%MOD;}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String in[] = br.readLine().trim().split(" ");
        int test = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (test-- > 0){


            String s = br.readLine().trim();
            int n = s.length();


            Hashing h = new Hashing(s.toCharArray(), 31, (int)1e9+7);

            int cnt =0 ;

            if (n%2==0){
                for (int i=2;i<=n-2;i+=2){

                    int b1 = 0, e1 = (i/2)-1;
                    int b2 = e1+1, e2 = i-1;
                    int b3 = i, e3 = (i+n)/2-1;
                    int b4 = e3+1, e4 = n-1;

                    boolean c1 = h.getHash(b1, e1)==h.getHash(b2, e2);
                    boolean c2 = h.getHash(b3, e3)==h.getHash(b4, e4);

                    if (c1&&c2){
                        ++cnt;
                    }

                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
