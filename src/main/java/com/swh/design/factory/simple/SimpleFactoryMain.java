package com.swh.design.factory.simple;

/**
 *  简单工厂设计模式
 *  可以是实现工厂的要求 一个工厂可以生产出不同产品来
 *  但是 这种方式耦合性高  假如需要再加一种产品  需要修改代码逻辑
 *  违背了 开闭原则
 *  耦合度高 扩展性差
 *
 */
public class SimpleFactoryMain {

    public static void main(String[] args) {
        IMilk jdMilk = SimpleFactory.creatMilk(SimpleFactory.JD);
        jdMilk.product();
        IMilk mnMilk = SimpleFactory.creatMilk(SimpleFactory.MN);
        mnMilk.product();
    }
}
