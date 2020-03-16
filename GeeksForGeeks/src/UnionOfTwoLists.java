import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoLists {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    Node findUnion(Node head1, Node head2) {
        Node Union = new Node(-1);
        Node ans = null;
        Set<Integer> so = new HashSet<>();
        while (head1 != null) {
            so.add(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            so.add(head2.data);
            head2 = head2.next;
        }
        for (Integer x : so) {
            Union.next = new Node(x);
            if (ans == null) {
                ans = Union;
            }
            Union=Union.next;
        }
        return ans;
    }


//        Set<Integer>s= new HashSet<>();
//        s.add(1);
//        s.add(2);
//        s.add(1);
//        s.add(2);
//        s.add(3);
//        for (Integer x:s) {
//            System.out.println(x);
//        }
//
//    }
//    public static void main(String[] args) {
//        findUnion();
//    }
}
