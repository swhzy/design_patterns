package com.swh.design.factory.factorymethod;

public class TelunSuFactory extends MengNiuFactory{
    @Override
    public IMilk create() {
        return new TelunSuMilk();
    }
}
