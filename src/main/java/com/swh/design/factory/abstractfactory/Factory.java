package com.swh.design.factory.abstractfactory;

public class Factory extends IFactory{
    @Override
    IMilk createJDMilk() {
        return new JinDianMilk();
    }

    @Override
    IMilk createMnMilk() {
        return new MengNiuMilk();
    }

    @Override
    IMilk createTlsMilk() {
        return new TelunSuMilk();
    }
}
