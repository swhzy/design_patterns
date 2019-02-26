package com.swh.design.simgle;

/**
 * 懒汉式:双重检查加锁
 * 优缺点跟经典懒汉式一致
 * 加入多层判断 保证了不会创建多个实例
 * volatile 关键字 是防止指令重排序
 * lazy =new Lazy1(); 这个代码会发生指令重排序 这段代码在底层执行的时候不是原子操作
 * 事实上在 JVM 中这句话大概做了下面 3 件事情。
 * 1. 给 lazy 分配内存
 * 2. 调用 Lazy1 的构造函数来初始化成员变量，形成实例
 * 3. 将lazy对象指向分配的内存空间（执行完这步lazy才是非 null了）
 * 在JVM的即时编译器中存在指令重排序的优化。
 * 也就是说上面的第二步和第三步的顺序是不能保证的，
 * 最终的执行顺序可能是 1-2-3 也可能是 1-3-2。如果是后者，
 * 则在 3 执行完毕、2 未执行之前，当前线程停止了，被线程二抢占了，
 * 这时 lazy 已经是非 null 了（这个引用已经指向了分配的内存空间,但却没有初始化），
 * 所以线程二会直接返回 lazy，然后使用，然后顺理成章地报错。
 * 线程的指令重排序:简单的说 就是jvm会对执行的代码指令进行优化处理 有可能会置换两个
 * 没有因果关系的代码指令 进行执行 eg：
 * 1. int a =0
 * 2. int b =1
 * 这个两个赋值  的先后对代码不会有影响 ，那么就会有可能发生指令重排序
 * 执行顺序 有可能 是  1-2  或者 2-1  都是有可能的。
 */
public class Lazy1 {
    private static volatile Lazy1 lazy;

    private Lazy1() {
    }

    public static Lazy1 INSTANCE1() {
        if (lazy == null) {
            synchronized (Lazy1.class) {
                if (lazy == null) {
                    lazy = new Lazy1();
                }
            }
        }
        return lazy;
    }
}
