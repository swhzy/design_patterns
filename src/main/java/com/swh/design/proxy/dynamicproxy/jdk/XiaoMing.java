package com.swh.design.proxy.dynamicproxy.jdk;

/**
 * 原始类
 */
public class XiaoMing implements Person{

    @Override
    public void findJob() {
        System.out.println("---小明面试---");
    }

    // 新增方法实现
    @Override
    public void findLove() {
        System.out.println("---坠入爱河---");
    }
}
