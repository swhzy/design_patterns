package com.swh.design.proxy.handwritingproxy;

public class JdkClient {

    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy(new XiaoMing());
        // 获取到动态代理类
        Person o = (Person) jdkProxy.newProxy();
        // 调用动态代理方法
        o.findLove();

    }
}
