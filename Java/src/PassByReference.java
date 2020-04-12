class Reference {
    int num = 1;
}
public class PassByReference {
    public static void change(Reference o) {
        o.num = 2;
    }
    public static void main(String[] args) {
        Reference r1 = new Reference();
        change(r1);
        System.out.println(r1.num);
    }
}
