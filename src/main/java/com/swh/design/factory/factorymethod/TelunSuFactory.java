package com.swh.design.factory.factorymethod;

/**
 * 生产特仑苏的工厂
 */
public class TelunSuFactory extends MengNiuFactory{
    @Override
    public IMilk create() {
        return new TelunSuMilk();
    }
}
