package com.swh.design.simgle;

/**
 *
 *   这种方式可以防止单利被破坏
 *
 */

public class ReflexSingleton {

    private  static     ReflexSingleton reflexSingleton = new ReflexSingleton();
   private ReflexSingleton(){
            if(reflexSingleton !=null)throw new RuntimeException("单利被破坏");
   }


   public static ReflexSingleton getInstance(){
       return reflexSingleton;
   }



    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
       try {
           ReflexSingleton reflexSingleton = ReflexSingleton.class.newInstance();
       }catch (Exception e){
           e.printStackTrace();
       }
        ReflexSingleton instance = ReflexSingleton.getInstance();
    }
}
