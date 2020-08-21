import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A591 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        float l = Float.parseFloat(br.readLine());
        float a = Float.parseFloat(br.readLine());
        float b = Float.parseFloat(br.readLine());
        float ans = l * 1.0f * a / (a+b);
        System.out.println(ans);
    }
}
