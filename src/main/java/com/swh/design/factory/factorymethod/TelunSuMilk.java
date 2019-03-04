package com.swh.design.factory.factorymethod;

/**
 * 产品类 -- 特仑苏
 */
public class TelunSuMilk implements IMilk {

    @Override
    public void product() {
        System.out.println("this is tls milk");
    }
}
