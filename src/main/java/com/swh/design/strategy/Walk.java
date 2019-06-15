package com.swh.design.strategy;

public class Walk implements Traffic{
    @Override
    public void traffic() {
        System.out.println("通过步行来");
    }
}
