// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

class LargestBST
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if(!currVal.equals("N"))
            {

                // Create the left child for the curr node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= s.length)
                break;
            currVal = s[i];

            // If the right child is not null
            if(!currVal.equals("N"))
            {

                // Create the right child for the curr node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();
            System.out.println(T.largestBst(root));

            t--;
        }
    }
}

// } Driver Code Ends
//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 

//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    static int ans = 0;

    static class MinMax{
        int min;
        int max;
        int size;
        boolean isBST;
        MinMax(int min, int max, boolean isBST, int size){
            this.min = min;
            this.max = max;
            this.isBST = isBST;
            this.size = size;
        }
    }
    static int largestBst(Node root)
    {
        // Map<Node, Integer> hash = new HashMap<>();
        // solve(root, hash);
        ans = 1;
        calculate(root);
        return ans;
    }

    static MinMax calculate(Node root){
        if (root.left == null && root.right == null) {
            return (new MinMax(root.data, root.data, true, 1));
        }
        MinMax minMax = new MinMax(root.data, root.data, true, 1);
        MinMax left = null;
        MinMax right = null;
        if (root.left!=null) {
            left = calculate(root.left);
            if (left.max < minMax.min) {
                minMax.min = left.min;
                minMax.isBST = minMax.isBST && left.isBST;
                minMax.size += left.size;
            } else {
                minMax.isBST = false;
            }
        }
        if (root.right!=null){
            right =calculate(root.right);
            if (right.min > minMax.max) {
                minMax.max = right.max;
                minMax.isBST = minMax.isBST && right.isBST;
                minMax.size += right.size;
            } else {
                minMax.isBST = false;
            }
        }
        if (minMax.isBST){
            ans = Math.max(minMax.size, ans);
        }
        return minMax;
    }
//    static int solve(Node root, Map<Node, Integer>hash){
//        if (root == null){
//            return 0;
//        }
//        int left = solve(root.left, hash);
//        int right = solve(root.right, hash);
//        hash.put(root, left+right+1);
//        // System.out.println(root.data + " " + hash.get(root));
//        return left+right+1;
//    }

}