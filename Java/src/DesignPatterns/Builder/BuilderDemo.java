package DesignPatterns.Builder;

public class BuilderDemo {
    public static void main(String[] args) {
        CDBuilder cdBuilder = new CDBuilder();
        CDType cdType1 = cdBuilder.buildSamsungCD();
        cdType1.showNames();

        CDType cdType2 = cdBuilder.buildSonyCD();
        cdType2.showNames();
    }
}
