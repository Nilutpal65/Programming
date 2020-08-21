import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class L1451 {

    public static String arrangeWords(String text) {
        String a[] = text.split(" ");
        int len = a.length;
        List<String>L = new ArrayList<>();
        String first = (char)(a[0].charAt(0)-'A'+'a') + a[0].substring(1);
        L.add(first);
        for (int i=1;i<len;++i){
            L.add(a[i]);
        }
        Collections.sort(L, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        String ans = "";
        first = L.get(0);
        char firstChar = first.charAt(0);
        if (firstChar>='a' && firstChar<='z'){
            firstChar = (char)(firstChar - 'a' + 'A');
        }
        first = firstChar + first.substring(1);

        ans = first;
        for (int i=1;i<L.size();++i){
            ans += " " + L.get(i);
        }
        return  ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String test = br.readLine();
        System.out.println(arrangeWords(test));

        //String in[] = br.readLine().trim().split(" ");
    }
}
