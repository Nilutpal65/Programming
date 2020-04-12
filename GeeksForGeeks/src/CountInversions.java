import org.omg.CORBA.INTERNAL;

import javax.xml.soap.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CountInversions {
    static long ans = 0;
    static void mergeSort(long a[],int start, int end){
        if (start<end) {
            int mid = (start+end)/2;
            mergeSort(a,start, mid);
            mergeSort(a,mid+1,end);
            merge(a,start,mid,end);
        }
    }
    static void merge(long a[],int start, int mid, int end){
        int n1 = mid-start+1;
        int n2 = end-mid;

        long L[] = new long[n1];
        long R[] = new long[n2];
        // System.out.println(start + " " +mid + " " + end);
        for (int i=0;i<n1;++i){
            L[i] = a[i+start];
        }
        for (int i=0;i<n2;++i){
            R[i] = a[i+mid+1];
        }
        int cnt = start;
        int i = 0;
        int j = 0;
        while (i<n1 && j<n2){
            if (L[i]<=R[j]){
                a[cnt++] = L[i++];
            } else {
                ans += n1 - i;
                a[cnt++] = R[j++];
            }
        }
        while(i<n1) a[cnt++] = L[i++];
        while (j<n2) a[cnt++] = R[j++];
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            String in[] = br.readLine().split(" ");
            long A[] = new long[n+1];
            for (int i=0;i<n;++i){
                A[i] = Long.parseLong(in[i]);
            }
            ans = 0;
            mergeSort(A,0,n-1);
            System.out.println(ans);
        }
    }
}
