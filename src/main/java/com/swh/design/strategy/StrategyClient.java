package com.swh.design.strategy;

public class StrategyClient {
    public static void main(String[] args) {
        Person person = new XiaoMing();

        person.travel(TrafficType.WALK.traffic);

    }
}
