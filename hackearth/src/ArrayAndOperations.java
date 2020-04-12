import java.util.Scanner;

public class ArrayAndOperations {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long[] arr = new long[n];

        for(int i_arr=0; i_arr<n; i_arr++)
        {
            arr[i_arr] = input.nextLong();
        }

        long out_ = minsum_and(arr, n);
        System.out.println(out_);

    }

    static long minsum_and(long[] arr, int n){
        long ans = Integer.MAX_VALUE ;
        for (int i=0;i<n;++i) {
            long temp_ans = arr[i];
            long cur = arr[i] ;
            for (int j=0;j<n;++j) {
                if (i!=j) {
                    cur &= arr[j];
                }
                ans += cur;
            }
            ans = Math.min(ans, temp_ans);
        }
        return ans ;
    }
}
