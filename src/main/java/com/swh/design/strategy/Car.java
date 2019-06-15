package com.swh.design.strategy;

public class Car implements Traffic{
    @Override
    public void traffic() {
        System.out.println("使用汽车去旅游");
    }
}
