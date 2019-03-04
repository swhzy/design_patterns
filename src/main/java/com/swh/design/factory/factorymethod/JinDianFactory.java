package com.swh.design.factory.factorymethod;

/**
 * 生产经典牛奶的工厂
 */
public class JinDianFactory implements IFactory{

    @Override
    public IMilk create() {
        return new JinDianMilk();
    }
}
