public class Cloneable implements java.lang.Cloneable {
    protected Object Clone()throws CloneNotSupportedException{
        return super.clone();
    }
    String name = "nilutpal";
    public static void main(String[] args) {
        Cloneable ob1 = new Cloneable();
        try {
            Cloneable ob2 = (Cloneable)ob1.clone();
            System.out.println(ob2.name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
