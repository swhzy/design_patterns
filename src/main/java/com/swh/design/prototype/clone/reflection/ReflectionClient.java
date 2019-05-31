package com.swh.design.prototype.clone.reflection;

public class ReflectionClient {
    public static void main(String[] args) throws CloneNotSupportedException {
        Pen pen = new Pen();
        pen.setColor("红色");
        Refill refill = new Refill();
        refill.setLength("1L");
        refill.setColor("黑色");
        pen.setRefill(refill);
        Pen clone = pen.clone();
        System.out.println("原型pen:" + pen.hashCode());
        System.out.println("复制品pen:" + clone.hashCode());
        System.out.println("原型Refill:" + pen.getRefill().hashCode());
        System.out.println("复制品Refill:" + clone.getRefill().hashCode());
    }
}
