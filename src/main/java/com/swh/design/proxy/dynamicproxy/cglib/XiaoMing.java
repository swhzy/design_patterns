package com.swh.design.proxy.dynamicproxy.cglib;


/**
 * 原始类
 */
public class XiaoMing{

    public void findJob() {
        System.out.println("---小明面试---");
    }

    // 新增方法实现
    public void findLove() {
        System.out.println("---坠入爱河---");
    }
}
