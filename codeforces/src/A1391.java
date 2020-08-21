import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1391 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String in[] = br.readLine().trim().split(" ");
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            for (int i=1;i<=n;++i){
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}
