package com.swh.design.adapter.type1;

import com.swh.design.adapter.AmericanPlug;
import com.swh.design.adapter.ChinesePlug;

public class Adapter implements ChinesePlug {
    private AmericanPlug americanPlug;

    public Adapter(AmericanPlug americanPlug) {
        this.americanPlug = americanPlug;
    }

    @Override
    public void chainesePlug() {
        System.out.println("使用转换器把美式插头转换成中式插头");
        americanPlug.americanPlug();
    }
}
