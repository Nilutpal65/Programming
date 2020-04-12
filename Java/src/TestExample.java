import javafx.geometry.Pos;

import java.util.*;

public class TestExample {
    public static void main(String[] args){
        Integer i = 100;
        sortPriorityQueue();
        // System.out.println(Integer.bitCount(i));
    }
    static class Post implements Comparable<Post>{
        int num;
        Post(int num){
            this.num = num;
        }

        public Integer getNum() {
            return num;
        }

        @Override
        public int compareTo(Post o) {
            return this.getNum().compareTo(o.getNum());
        }
    }
    static class cmp implements Comparator<Post>{
        @Override
        public int compare(Post o1, Post o2) {
            return o2.num-o1.num;
        }
    }
    static void sortPriorityQueue(){
        PriorityQueue<Post> p1 = new PriorityQueue<Post>(5, new cmp());
        Post p11 = new Post(1);
        Post p12 = new Post(3);
        Post p13 = new Post(2);
        Post p14 = new Post(4);
        Post p15 = new Post(5);

        p1.add(p11);
        p1.add(p12);
        p1.add(p13);
        p1.add(p14);
        p1.add(p15);

//        List<Post>L = new ArrayList<>();
//        L.add(p11);
//        L.add(p12);
//        L.add(p13);
//        L.add(p14);
//        L.add(p15);
//        Collections.sort(L);

        while (!p1.isEmpty()){
            Post p = p1.peek();
            System.out.println(p.num);
            p1.poll();
        }
    }
}
