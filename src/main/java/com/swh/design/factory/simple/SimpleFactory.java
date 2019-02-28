package com.swh.design.factory.simple;

public class SimpleFactory {

    public static final int JD = 1;
    public static final int MN = 2;
    public static final int TLS = 3;

    public static IMilk creatMilk(int i) {
        switch (i) {
            case 1:
                return new JinDianMilk();
            case 2:
                return new MengNiuMilk();
            case 3:
                return new TelunSuMilk();
            default:
                System.out.println("no such milk");
        }
        return null;
    }

}
