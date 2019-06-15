package com.swh.design.strategy;

public class Plain implements Traffic{
    @Override
    public void traffic() {
        System.out.println("使用飞机去旅游");
    }
}
