package DesignPatterns.Builder;

public class CDBuilder {
    public CDType buildSonyCD(){
        CDType sonyCD = new CDType();
        sonyCD.addItems(new Sony());
        return sonyCD;
    }
    public CDType buildSamsungCD(){
        CDType samsungCD = new CDType();
        samsungCD.addItems(new Samsung());
        return samsungCD;
    }
}
