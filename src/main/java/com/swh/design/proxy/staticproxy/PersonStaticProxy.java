package com.swh.design.proxy.staticproxy;

/**
 * 代理类
 */


public class PersonStaticProxy {

    private Person person;

    public PersonStaticProxy(Person person) {
        this.person = person;
    }

    public void findJob(){
        System.out.println("-------联系公司--------");
        person.findJob();
        System.out.println("-------获取结果--------");

    }




}
