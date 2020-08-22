import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Test
{
    // Driver code
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        String s[] = new String[100];
        s[0] = "1";
        s[1] = "11";

        for (int i=2; i<25;++i) {
            s[i] = "";
            String current = s[i-1];
            int len = current.length();

            int j = 0;
            while (j<len) {
                char c = current.charAt(j);
                int k = j;
                while (j<len && current.charAt(j)==c) ++j;
                s[i] += Integer.toString(j-k);
                s[i] += c;
            }

            //System.out.println(s[i]);
        }

        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(s[n-1]);
        }
    }
}  
