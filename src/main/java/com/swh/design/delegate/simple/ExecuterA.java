package com.swh.design.delegate.simple;

public class ExecuterA implements IExecuter{
    @Override
    public void executer(String com) {
        System.out.println("注册");
    }
}
