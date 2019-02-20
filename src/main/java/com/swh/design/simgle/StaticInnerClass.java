package com.swh.design.simgle;

/**
 *
 *  静态内部类
 *      在只使用了外部类，但是没有使用内部类的情况下，内部类里面的东西不会被初始化。
 *      这种实现单利模式的方式 既不会浪费内存空间 又不会 有并发的问题
 *
 */
public class StaticInnerClass {
    private StaticInnerClass(){}

    private static class SimpleInstance{
        private static final StaticInnerClass sic = new StaticInnerClass();
    }


    public static StaticInnerClass getInstance(){
        return SimpleInstance.sic;
    }
}
