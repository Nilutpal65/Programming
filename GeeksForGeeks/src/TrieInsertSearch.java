import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrieInsertSearch {
    static class Trie{
        Trie children[] = new Trie[30];
        boolean isComplete;
        Trie(){
            for (int i=0;i<30;++i)
                children[i] = null;
            isComplete = false;
        }
    }

    static void insert(Trie t, String word){
        int i = 0;
        while(i<word.length()){
            int cur = word.charAt(i) - 'a';
            if (t.children[cur]==null) {
                t.children[cur] = new Trie();
            }
            t = t.children[cur];
            ++i;
        }
        t.isComplete = true;
    }
    static boolean search(Trie t, String word){
        int i = 0 ;
        while(i<word.length()){
            int cur = word.charAt(i) - 'a';
            if (t.children[cur]==null) {
                return false;
            }
            t = t.children[cur];
            ++i;
        }
        return t.isComplete;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            String in[] = br.readLine().split(" ");
            String needle = br.readLine();
            Trie t = new Trie();
            for(int i=0;i<in.length;++i){
                insert(t,in[i]);
            }
            boolean ans = search(t, needle);
            System.out.println(ans ? 1 : 0);
        }
    }
}
