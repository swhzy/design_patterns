package com.swh.design.factory.factorymethod;

/**
 * 产品类(蒙牛)
 */
public class MengNiuMilk implements IMilk {

    @Override
    public void product() {
        System.out.println("this is meng niu milk");
    }
}
