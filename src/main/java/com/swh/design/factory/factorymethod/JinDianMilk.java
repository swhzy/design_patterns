package com.swh.design.factory.factorymethod;

/**
 * 产品类 -- 经典
 */
public class JinDianMilk implements IMilk {

    @Override
    public void product() {
        System.out.println("this is Jing Dian milk");
    }
}
