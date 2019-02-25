package com.swh.design.simgle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflexSingleton {

    private  static  volatile   ReflexSingleton reflexSingleton;
    private static boolean flag = Boolean.FALSE;
   private ReflexSingleton(){
        throw new RuntimeException("sss");
   }

    public static   ReflexSingleton getInstance(){
        if(reflexSingleton == null) {
            synchronized (ReflexSingleton.class){
                if(reflexSingleton == null) {
                    reflexSingleton = new ReflexSingleton();
                }
            }
        }
        return reflexSingleton;
    }

    public static void main(String[] args) {
        System.out.println(ReflexSingleton.getInstance() );
        /*try {
           // ReflexSingleton invoke = ReflexSingleton.class.newInstance();
            System.out.println(ReflexSingleton.getInstance() );

        }*/  /*catch (IllegalAccessException e) {
            e.printStackTrace();
        }  catch (InstantiationException e) {
            e.printStackTrace();
        }*/
    }
}
