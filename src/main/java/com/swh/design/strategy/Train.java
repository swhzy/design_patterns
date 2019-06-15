package com.swh.design.strategy;

public class Train implements Traffic{

    @Override
    public void traffic() {
        System.out.println("使用火车去旅行");
    }
}
