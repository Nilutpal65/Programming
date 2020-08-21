public class LambdaOperation {
    interface funcInter1{
        int operation(int a, int b);
    }
    interface funcInter2{
        void sayMessage(String message);
    }
    private int operate(int a,int b, funcInter1 fObj){
        return fObj.operation(a,b);
    }
    public static void main(String[] args){
        funcInter1 fOb = (int a, int b) -> a+b;
        LambdaOperation t = new LambdaOperation();
        System.out.println(t.operate(1,2,fOb));
        System.out.println(fOb.operation(1,2));

        funcInter2 fo2 = (String s)->System.out.println("Hello "+s);
        fo2.sayMessage("Nilutpal");
    }
}
