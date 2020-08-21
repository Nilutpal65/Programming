package DesignPatterns;

public class JDBCSingletonClass {
    private static JDBCSingletonClass obj;
    private JDBCSingletonClass() { }
    public static JDBCSingletonClass getInstance(){
        if (obj == null) {
            synchronized (JDBCSingletonClass.class){
                obj = new JDBCSingletonClass();
            }
        }
        return obj;
    }
}
