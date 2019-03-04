package com.swh.design.factory.abstractfactory;

/**
 * 经典牛奶  产品类
 */
public class JinDianMilk implements IMilk {

    @Override
    public void product() {
        System.out.println("this is Jing Dian milk");
    }
}
