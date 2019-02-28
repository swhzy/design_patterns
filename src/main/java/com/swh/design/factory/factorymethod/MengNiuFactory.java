package com.swh.design.factory.factorymethod;

public class MengNiuFactory implements IFactory{

    @Override
    public IMilk create() {
        return new MengNiuMilk();
    }
}
