package com.swh.design.prototype;

public class Pen implements Cloneable{ // 笔

    private String color; // 笔筒的颜色

    private Refill refill; //笔芯

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Refill getRefill() {
        return refill;
    }

    public void setRefill(Refill refill) {
        this.refill = refill;
    }

    @Override
    public Pen clone() throws CloneNotSupportedException {
        Pen clone1 = (Pen) super.clone();
       /* Refill clone = refill.clone();
        clone1.setRefill(clone);*/
        return clone1;
    }
}
