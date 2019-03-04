package com.swh.design.factory.abstractfactory;

/**
 * 蒙牛 产品类
 */

public class MengNiuMilk implements IMilk {

    @Override
    public void product() {
        System.out.println("this is meng niu milk");
    }
}
