import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C1353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String in[] = br.readLine().trim().split(" ");

        long d[] = new long[500001];

        long odd = 1;

        d[1] = 0;
        for (int i=3; i < 500001; i+=2){
            d[i] = 4L * (odd * 1L * (i-1)) + d[i-2];
            ++odd;
        }

        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
        }
    }
}
