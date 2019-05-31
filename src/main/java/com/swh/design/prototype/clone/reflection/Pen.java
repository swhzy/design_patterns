package com.swh.design.prototype.clone.reflection;

public class Pen { // 笔

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
    protected Pen clone() throws CloneNotSupportedException {
        Class<Pen> penClass = Pen.class;
        try {
            Pen pen = penClass.newInstance();
            pen.setColor(this.color);
            Class<Refill> refillClass = Refill.class;
            Refill refill = refillClass.newInstance();
            refill.setColor(this.refill.getColor());
            refill.setLength(this.refill.getLength());
            pen.setRefill(refill);
            return pen;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;

    }
}
