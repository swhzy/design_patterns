package com.swh.design.simgle;

/**
 * 饿汉式的变种 优缺点跟饿汉式一样
 */
public class Hungry1 {
    private static Hungry1 hungry1;

    static {
        hungry1 = new Hungry1();
    }

    private Hungry1(){}

    public static Hungry1 INSTANCE(){
        return hungry1;
    }
}
