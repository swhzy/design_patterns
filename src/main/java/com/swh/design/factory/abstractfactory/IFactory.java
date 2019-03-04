package com.swh.design.factory.abstractfactory;

/**
 * 抽象工厂
 */
public abstract class IFactory {

    abstract IMilk createJDMilk();

    abstract IMilk createMnMilk();

    abstract IMilk createTlsMilk();

}
