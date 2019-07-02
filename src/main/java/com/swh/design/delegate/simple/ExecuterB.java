package com.swh.design.delegate.simple;

public class ExecuterB implements IExecuter{

    @Override
    public void executer(String com) {
        System.out.println("登录");
    }
}
