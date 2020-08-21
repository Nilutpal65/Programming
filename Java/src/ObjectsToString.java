import java.util.Objects;

class Pair<K,V> {
    public K key;
    public V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public String toString() {
        return "key : " + Objects.toString(key) + ", value : " + Objects.toString(value, "no value");
    }

    public boolean equals(Object o){
        if (o instanceof Pair) {
            Pair<?, ?>P = (Pair<?, ?>)o;
            return Objects.equals(P.key, key) && Objects.equals(P.value, value);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(key, value);
    }
}

public class ObjectsToString {
    public static void main(String[] args) {
        Pair<String, String> p1 = new Pair<String, String>("nilutpal", "borgohain");
        Pair<String, String> p2 = new Pair<String, String>("nilutpal", "borgohain");
        System.out.println(p1.equals(2));
        System.out.println(p1.toString());
        System.out.println(p1.hashCode());
    }
}
