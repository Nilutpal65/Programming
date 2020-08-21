//public class Sample
//{
//        B obj;
//
//        // Parameterized constructor with object of B
//        // as a parameter
//        Sample(B obj)
//        {
//            this.obj = obj;
//
//            // calling display method of class B
//            obj.display();
//        }
//
//
//}
//
//class B
//{
//    int x = 5;
//
//    // Default Contructor that create a object of A
//    // with passing this as an argument in the
//    // constructor
//    B()
//    {
//        Sample obj = new Sample(this);
//    }
//
//    // method to show value of x
//    void display()
//    {
//        System.out.println("Value of x in Class B : " + x);
//    }
//
//    public static void main(String[] args) {
//        B obj = new B();
//    }
//}

// An abstract class with a final method
class Base {
    void fun() {

    }
}

class Derived extends Base {
    void fun(){

    }
}

interface in1 {
    void test1();
    default void test4(){

    }
}
interface in2 {
    void test2();
}
interface in3 extends in1,in2 {
    void test3();
}
class cl1 implements in3 {
    public void test3() {

    }
    public void test1() {

    }
    public void test2() {

    }
}
abstract class Instant{
    abstract void test();
}
class Main {
    public static void main(String args[]) {
        Instant i = new Instant() {
            void test(){

            }
        };
        i.test();
    }
}