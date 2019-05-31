package com.swh.design.prototype.clone.deep;

public class DeepClient {

    public static void main(String[] args) {
        Pen pen = new Pen();
        pen.setColor("蓝色");
        pen.setRefill(new Refill());
        try {
            Pen clone = pen.clone();
            System.out.println("原型pen:" + pen.hashCode());
            System.out.println("复制品pen:" + clone.hashCode());
            System.out.println("原型Refill:" + pen.getRefill().hashCode());
            System.out.println("复制品Refill:" + clone.getRefill().hashCode());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
