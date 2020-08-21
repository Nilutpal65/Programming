import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class KosarajuAlgorithm {

    static int N;
    static ArrayList<Integer>[] adjList, adjListR, graph;
    static Stack<Integer> stack, stack2;
    static boolean[] visited;
    static int SCC;
    static Map<Integer, Boolean>M = new HashMap<>();


    public static int SCC()
    {
        stack = new Stack<Integer>();
        visited = new boolean[N];
        graph = adjList;
        for(int i = 0; i < N; ++i)
            if(!visited[i])
                dfs(i, true);

        visited = new boolean[N];
        graph = adjListR;
        SCC = 0;
        while(!stack.isEmpty())
        {
            int u = stack.pop();
            if(!visited[u])
            {
                stack2 = new Stack<>();
                SCC++;
                dfs(u, false);
                if (stack2.size() == 1){
                    M.put(stack2.peek(), true);
                }
            }
            //if visited then this vertex belongs to the SCC of the vertex which visited it
        }

        return SCC;
    }

    public static void dfs(int u, boolean fillingStack)
    {
        visited[u] = true;
        for(int v: graph[u])
            if(!visited[v])
                dfs(v, fillingStack);
        if(fillingStack)
            stack.push(u);
        if(!fillingStack)
            stack2.push(u);
    }
}

public class AWalkToRemeber {
    static ArrayList<Integer>[] gr, rgr;
    static boolean visited[];

    static void dfs(int u, Stack<Integer>S){
        visited[u] = true;
        for (Integer e:gr[u]){
            if (!visited[e]){
                dfs(e, S);
            }
        }
        S.push(u);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().trim().split(" ");


        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        gr = new ArrayList[n+1];
        rgr = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i=0;i<=n;++i){
            gr[i] = new ArrayList<>();
            rgr[i] = new ArrayList<>();
        }

        Arrays.fill(visited, false);



        KosarajuAlgorithm K = new KosarajuAlgorithm();


        for (int i=0;i<m;++i){
            in = br.readLine().trim().split(" ");
            int u = Integer.parseInt(in[0]);
            int v = Integer.parseInt(in[1]);
            --u; --v;
            gr[u].add(v);
            rgr[v].add(u);
        }

        K.N = n;
        K.adjList = gr;
        K.adjListR = rgr;
        K.SCC();

        for (int i=0;i<n;++i){
            if (K.M.containsKey(i)){
                System.out.print(0 + " ");
            } else {
                System.out.print(1 + " ");
            }
        }


//        Stack<Integer> S = new Stack<>();
//        for (int i=1;i<=n;++i){
//            if (!visited[i]){
//                dfs(i, S);
//            }
//        }
//
//
//        Arrays.fill(visited, false);
//        Stack<Integer> rS[] = new Stack[n+1];
//        for (int i=1;i<=n;++i) {
//            rS[i] = new Stack<>();
//        }
//        int cnt = 1;
//
//        Collections.reverse(S);
//
//        while (!S.empty()){
//            int top = S.peek();
//            S.pop();
//            if(!visited[top]){
//                dfs(top, rS[cnt]);
//                cnt++;
//            }
//        }
//
//        Map<Integer, Boolean>M = new HashMap<>();
//
//        for (int i=1;i<=n;++i){
//            if (!rS[i].empty()){
//                if (rS[i].size() == 1){
//                    M.put(rS[i].peek(), true);
//                }
//            }
//        }
//
//        for (int i=1;i<=n;++i){
//            if (M.containsKey(i)){
//                System.out.print(0 + " ");
//            } else {
//                System.out.print(1 + " ");
//            }
//        }

    }
}
