package com.swh.design.simgle;

/**
 * 懒汉式
 * 优点:只有用到这个实例时才会创建  避免了内存空间的浪费
 * 缺点: synchronized 使多线程变成了串行  多线程并发的情况下会影响程序效率
 */
public class Lazy {

    private static Lazy lazy;

    private Lazy() {
    }

    public synchronized static Lazy INSTANCE() {
        if (lazy == null) {
            lazy = new Lazy();
        }
        return lazy;
    }
}
