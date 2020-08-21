import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class SortStack {
    public Stack<Integer> sort(Stack<Integer> s)
    {
        Stack<Integer> temp = new Stack<>();

        while(!s.empty()){
            int cur = s.peek();
            s.pop();
            if (temp.empty()){
                temp.push(cur);
            } else {
                while (!temp.empty() && temp.peek()>cur){
                    int cur2 = temp.peek();
                    temp.pop();
                    s.push(cur2);
                }
                temp.push(cur);
            }
        }

        return temp;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            Stack<Integer> s=new Stack<>();
            int n=sc.nextInt();
            while(n-->0)
                s.push(sc.nextInt());
            SortStack g=new SortStack();
            Stack<Integer> a=g.sort(s);
            while(!a.empty()){
                System.out.print(a.peek()+" ");
                a.pop();
            }
            System.out.println();
        }
    }
}
