package com.swh.design.factory.abstractfactory;

/**
 * 工厂的实现
 */
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
