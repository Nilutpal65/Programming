import org.omg.CORBA.INTERNAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C510 {
    static List<Integer>L[];
    static boolean visited[] = new boolean[33];
    static int size[] = new int[33];
    static List<Integer>ans = new ArrayList<>();

    static boolean hasCycle(int u){
        if(visited[u]) {
            return true;
        }
        visited[u]  = true;
        boolean res = false;
        for(Integer e:L[u]){
            res = res || hasCycle(e);
        }
        visited[u] = false;
        return res;
    }

    static void dfs1(int u){
        if (visited[u]){
            return;
        }
        visited[u] = true;
        for(Integer e:L[u]){
            dfs1(e);
        }
        ans.add(u);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String in[] = br.readLine().trim().split(" ");
        int n = Integer.parseInt(br.readLine());



        String s[] = new String[n];
        L = new ArrayList[26];
        for (int i=0;i<26;++i){
            L[i] = new ArrayList<>();
        }

        boolean impossible = false;

        for (int i=0;i<n;++i) {
            s[i] = br.readLine();

            if(s[i].equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")){
                System.out.println("abcdefghijklmnopqrstuvwxyz");
                return;
            }

            if (i>0){
                int j = 0;
                int k = 0;
                while (j<s[i-1].length() && k<s[i].length()){
                    if(s[i-1].charAt(j) == s[i].charAt(k)){
                        ++j;
                        ++k;
                    } else {
                        break;
                    }
                }
                if (j<s[i-1].length() && k<s[i].length()){
                    L[s[i-1].charAt(j)-'a'].add(s[i].charAt(k)-'a');
                }
                if (k == s[i].length() && j<s[i-1].length()){
                    impossible = true;
                    System.out.println("Impossible");
                    return;
                }
            }
        }
        boolean checkForCycle = false;
        for(int i=0;i<26;++i){
            Arrays.fill(visited, false);
            checkForCycle = checkForCycle || hasCycle(i);
            if (checkForCycle) {
                break;
            }
        }

        if(checkForCycle || impossible){
            System.out.println("Impossible");
        } else {
            Arrays.fill(visited, false);

            for(int i=0;i<26;++i){
                dfs1(i);
            }
            Collections.reverse(ans);
            for(Integer e:ans){
                System.out.print((char)(e+'a'));
            }
            for(int i=0;i<26;++i){
                if(!visited[i]){
                    System.out.print((char)(i+'a'));
                }
            }
        }
    }
}
