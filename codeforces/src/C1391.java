import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C1391 {
    static long power(long x, long y, long p)
    {
        long res = 1;
        x = x % p;
        if (x == 0) return 0;
        while (y > 0)
        {
            if((y & 1)==1)
                res = (res * x * 1L) % p;

            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long mod = 1000000007L;
        long pw = power(2L, n-1, mod);
        long fact = 1L;
        for (int i=1;i<=n;++i){
            fact = (fact * i) % mod;
        }
        long ans = fact - pw;
        if (ans > mod){
            ans -= mod;
        }
        if (ans < 0){
            ans += mod;
        }
        System.out.println(ans);
    }
}
