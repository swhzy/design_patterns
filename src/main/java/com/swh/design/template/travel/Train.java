package com.swh.design.template.travel;

public class Train extends TravelTemplate {
    @Override
    protected void selectTraffic() {
        System.out.println("使用火车去旅游");
    }
}
