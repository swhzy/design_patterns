package com.swh.design.template.travel;

public abstract class TravelTemplate {


    public void travel() {
        // 1.选择游玩的地方
        // 2.设计旅游攻略
        // 3.选择交通工具
        // 4.到达目的，开始游玩

        selectTravelPlace();

        designTravelRaiders();

        selectTraffic();

        arrivalsPlay();

    }

    private void arrivalsPlay() {
        System.out.println("到达目的地,开始游玩");
    }

    protected abstract void selectTraffic();

    private void designTravelRaiders() {
        System.out.println("设计旅游攻略");
    }

    private void selectTravelPlace() {
        System.out.println("选择游玩的地方");
    }

}
