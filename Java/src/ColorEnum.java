public class ColorEnum {
    interface Test {
        // public void Color();
    }
    enum Color implements Test{
        RED("APPLE"),
        BLUE("SKY"),
        GREEN("GRASS");

        private Color() {
            System.out.println(this.toString());
        }
        private Color(String s){
            System.out.println(s);
        }
    }
    public static void main(String[] args){
        Color c1 = Color.RED;
        Color arr[] = Color.values();
        for (Color col:arr){
            System.out.println(col + " at index " + col.ordinal());
        }
        System.out.println(Color.valueOf("RED"));

    }

}
