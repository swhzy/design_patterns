package com.swh.design.proxy.handwritingproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 */
public class JdkProxy  implements MyselfInvocationHandler {

    private Person person;

    public JdkProxy(Person person) {
        this.person = person;
    }


    public Object newProxy(){
        return MyselfProxy.newProxyInstance(new MyselfClassLoader(),person.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---在被代理类执行之前干点坏事---");
        Object invoke = method.invoke(person, args);
        System.out.println("---在被代理类执行之后干点坏事---");
        return invoke;
    }
}
