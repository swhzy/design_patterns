package com.swh.design.simgle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *  注册登记式
 *      这种实现单利模式  可以维护一组单利实例  spring中采用的就是这种模式
 *
 */
public class RegSingleton implements Serializable{

    private static Map<String,Object> singletonMap = new HashMap();

    static {
        singletonMap.put(RegSingleton.class.getName(),new RegSingleton());
    }

    protected RegSingleton(){}

    public static Object getInstance(String name){
        if(name == null){
            name = "RegSingleton";
        }
        if(singletonMap.get(name)==null){

            try {
                singletonMap.put(name, Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        return singletonMap.get(name);

    }

}
