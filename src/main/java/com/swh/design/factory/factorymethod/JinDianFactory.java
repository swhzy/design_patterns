package com.swh.design.factory.factorymethod;

public class JinDianFactory implements IFactory{

    @Override
    public IMilk create() {
        return new JinDianMilk();
    }
}
