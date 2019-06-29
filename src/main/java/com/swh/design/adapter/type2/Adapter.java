package com.swh.design.adapter.type2;

import com.swh.design.adapter.AmericanPlugImpl;
import com.swh.design.adapter.ChinesePlug;

public class Adapter extends AmericanPlugImpl implements ChinesePlug {
    @Override
    public void chainesePlug() {
        System.out.println("使用转换器把美式抽头转换成中式插头");
        super.americanPlug();
    }
}
