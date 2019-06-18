package com.swh.design.template.travel;

public class Plain extends TravelTemplate{
    @Override
    protected void selectTraffic() {
        System.out.println("使用飞机到达目的地");
    }
}
