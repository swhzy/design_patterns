package com.swh.design.simgle;

import java.io.*;

/**
 *  假如单利模式实现了序列化  会对单利模式进行破坏
 *  当对象序列化 然后再被反序列化的时候 会创建不同的实体
 *  因为反序列化的底层实现也是用的反射来创建对象的
 *   反序列化的底层代码实现:
 *      private Object readOrdinaryObject(boolean unshared) throws IOException {
 *          Object obj;
 *          try {
 *                  obj = desc.isInstantiable() ? desc.newInstance() : null;   //  此处如果对象实现了序列化Serializable接口，则通过反射创建对象 反射创建对象 会打破封装 创建出新的实例
 *              } catch (Exception ex) {
 *                  throw (IOException) new InvalidClassException(desc.forClass().getName(),
 *                  "unable to create instance").initCause(ex);
 *                  }
 *                  //此处省略部分代码
 *          if (obj != null && handles.lookupException(passHandle) == null && desc.hasReadResolveMethod()){ //  如果对象实现了readResolve() 方法  会通过上面创建的对象反射调用该方法
 *              Object rep = desc.invokeReadResolve(obj);
 *              if (unshared && rep.getClass().isArray()) {
 *                  rep = cloneArray(rep);
 *              }
 *          if (rep != obj) {
 *              handles.setObject(passHandle, obj = rep) //  把从readResolve()方法中拿到的返回结果重新复制给obj对象 进行返回
 *                  }
 *              }
 *              return obj;
 *          }
 *
 *       由上面的源码得出  只要对象中提供readResolve() 方法就可以防止反序列化创建新的实例
 *
 */
public class SerializableSingleton implements Serializable{

    private  static  volatile   SerializableSingleton serializableSingleton;

    public SerializableSingleton() {
    }

    public static   SerializableSingleton getInstance(){
        if(serializableSingleton == null) {
            synchronized (SerializableSingleton.class){
                if(serializableSingleton == null) {
                    serializableSingleton = new SerializableSingleton();
                }
            }
        }
        return serializableSingleton;
    }


    private Object readResolve() {
        return serializableSingleton;
    }


    public static void main(String[] args) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("serializable"));
            objectOutputStream.writeObject(SerializableSingleton.getInstance());
            File serializable = new File("serializable");
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(serializable));
            SerializableSingleton serializableSingleton = (SerializableSingleton) inputStream.readObject();
            System.out.println(serializableSingleton == SerializableSingleton.getInstance());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }





}


