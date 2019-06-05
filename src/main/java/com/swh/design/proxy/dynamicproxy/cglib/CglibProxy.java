package com.swh.design.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy extends XiaoMing implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("-----方法执行前干一些事----");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("----方法执行后干一些事-----");
        return invoke;
    }

    public <T>T getProxy(Class<T> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return (T)enhancer.create();
    }
}
