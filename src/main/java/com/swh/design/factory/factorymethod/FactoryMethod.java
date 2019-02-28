package com.swh.design.factory.factorymethod;

/**
 * 工厂方法模式
 * 这个种模式 工厂做到了抽象化 每加一种产品
 * 可以动态的扩展工厂 不需要修改之前的业务逻辑代码
 * 相比简单工厂模式 代码变得灵活了 符合了开闭原则
 * <p>
 * 缺点: 这种方式 随着产品种类的增加  会出现大量
 * 与之对应的工厂对象 工程会显得很臃肿
 */
public class FactoryMethod {

    public static void main(String[] args) {
        IFactory jinDianFactory = new JinDianFactory();

        IFactory mengNiuFactory = new MengNiuFactory();

        IFactory telunSuFactory = new TelunSuFactory();


        IMilk iMilk = jinDianFactory.create();
        iMilk.product();
        IMilk iMilk1 = mengNiuFactory.create();
        iMilk1.product();
        IMilk iMilk2 = telunSuFactory.create();
        iMilk2.product();

    }
}
