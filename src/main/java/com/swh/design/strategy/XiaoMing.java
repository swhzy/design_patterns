package com.swh.design.strategy;

public class XiaoMing implements Person{
    @Override
    public void travel(Traffic traffic) {
        System.out.println("计划，收拾东西，准备出发");
        traffic.traffic();
        System.out.println("到达目的地，开始游玩");
    }
}
