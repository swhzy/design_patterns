package com.swh.design.proxy.dynamicproxy.jdk;

public class JdkClient {

    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy(new XiaoMing());

        Person o = (Person) jdkProxy.newProxy();

        o.findLove();

    }
}
