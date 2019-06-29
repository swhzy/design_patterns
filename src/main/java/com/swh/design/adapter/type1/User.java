package com.swh.design.adapter.type1;

import com.swh.design.adapter.AmericanPlug;
import com.swh.design.adapter.AmericanPlugImpl;
import com.swh.design.adapter.ChinesePlug;

public class User {
    public static void main(String[] args) {
        AmericanPlug americanPlug = new AmericanPlugImpl();
        ChinesePlug chinesePlug = new Adapter(americanPlug);

        chinesePlug.chainesePlug();
    }
}
