// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;



public class PrimAlgorithm {


    public static void main(String args[])throws IOException
    {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int i=0; i<V; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j = 0; j < V; j++)
                    temp.add(Integer.MAX_VALUE);
                graph.add(temp);
            }
            str = read.readLine().trim().split(" ");
            int k = 0;
            while(E-- > 0)
            {
                int u = Integer.parseInt(str[k++]);
                int v = Integer.parseInt(str[k++]);
                int w = Integer.parseInt(str[k++]);
                u--;
                v--;
                graph.get(u).set(v, w);
                graph.get(v).set(u, w);
            }

            System.out.println(new MST().spanningTree(V,E,graph));
        }
    }
}

// } Driver Code Ends
//User function Template for Java
class g implements Comparable<g>{
    int to;
    int from;
    int dist;
    public g(int to, int from, int dist){
        this.to = to;
        this.from = from;
        this.dist = dist;
    }
    Integer getDist(){
        return dist;
    }

    @Override
    public int compareTo(g o) {
        return this.getDist().compareTo(o.dist);
    }
}

class MST
{
    static int parent[] = new int[1111];

    static int findSet(int v){
        return (parent[v]==v) ? v : (parent[v]=findSet(parent[v]));
    }

    static boolean isSameSet(int u, int v){
        return findSet(u)==findSet(v);
    }

    static void unionSet(int u, int v){
        parent[findSet(u)] = findSet(v);
    }

    static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph)
    {
        for (int i=0;i<=V;++i){
            parent[i]=i;
        }

        List<g> L= new ArrayList<>();
        for (int i=0;i<V;++i){
            for (int j=0;j<V;++j){
                if (graph.get(i).get(j) != Integer.MAX_VALUE){
                    L.add(new g(i+1,j+1,graph.get(i).get(j)));
                }
            }
        }
        Collections.sort(L);
//        for (g G:L){
//            System.out.println(G.to + " " + G.from + " " + G.dist);
//        }
        Map<Integer, Boolean>mo = new HashMap();
        int ans = 0;
        for (g G:L){
            if (isSameSet(G.to, G.from) == false) {
                unionSet(G.to, G.from);
                ans += G.dist;
            }
        }
        return ans;
    }
}

