package com.swh.design.proxy.staticproxy;

public class StaticProxyMain {

    public static void main(String[] args) {
        Person person = new Person();
        new PersonStaticProxy(person).findJob();
    }
}
