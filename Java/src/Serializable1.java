import java.io.*;
import java.util.HashMap;

public class Serializable1 implements java.io.Serializable{
    public int a;
    public String b;
    transient int c;
    private static long seriaversionUID = 129348938L;

    public Serializable1(int a, String b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

class Test {
    public static void main(String[] args)throws IOException, ClassNotFoundException {
        Serializable1 obj = new Serializable1(1, "nilutpal", 2);
        String filename = "file.ser";
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(obj);
            out.close();
            file.close();
            System.out.println("File has been Serialized!");
        } catch (Exception e) {

        }
        Serializable1 object1 = null;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object1 = (Serializable1)in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("a = " + object1.a);
            System.out.println("b = " + object1.b);
            System.out.println("c = " + object1.c);
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        HashMap<Integer, Integer> h = new HashMap<>();
    }
}
