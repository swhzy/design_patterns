package com.swh.design.simgle;

/**
 *   饿汉式
 *   优点：避免了多线程并发问题
 *   缺点: 创建好的对象不是及时的调用会浪费内存空间
 */
public class Hungry {
    private static Hungry hungry = new Hungry();

    private Hungry(){}

    public static Hungry INSTANCE(){
        return hungry;
    }


}
