package com.swh.design.prototype.clone.serialization;

import java.io.Serializable;

public class Refill implements Serializable { // 笔芯

    private String length; // 笔芯的长度

    private String color; // 笔芯墨水的颜色

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
