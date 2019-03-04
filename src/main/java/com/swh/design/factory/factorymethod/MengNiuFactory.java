package com.swh.design.factory.factorymethod;

/**
 * 生产蒙牛的工厂
 */
public class MengNiuFactory implements IFactory{

    @Override
    public IMilk create() {
        return new MengNiuMilk();
    }
}
