package com.swh.design.proxy.dynamicproxy.cglib;

public class CglibProxyClient {

    public static void main(String[] args) {

        XiaoMing proxy = new CglibProxy().getProxy(XiaoMing.class);

        proxy.findJob();
        /*XiaoHei proxy = new CglibProxy().getProxy(XiaoHei.class);

        proxy.Lame();*/
    }
}
