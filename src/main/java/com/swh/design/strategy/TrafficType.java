package com.swh.design.strategy;

public enum  TrafficType {
    CAR(new Car()),PLAIN(new Plain()),TRAIN(new Train()),WALK(new Walk());

    Traffic traffic;
    TrafficType(Traffic traffic) {
        this.traffic = traffic;
    }
}
