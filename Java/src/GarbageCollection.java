public class GarbageCollection {
    String obj_name;
    GarbageCollection(String obj_name) {
        this.obj_name = obj_name;
    }
    protected void finalize()throws Throwable {
        System.out.println(obj_name);
    }
    public static void main(String[] args) {
        GarbageCollection ob = new GarbageCollection("nilutpal");
        ob = null;
        new GarbageCollection("anonymous object");
        System.gc();
    }
}
