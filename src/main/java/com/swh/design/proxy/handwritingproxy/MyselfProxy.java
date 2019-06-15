package com.swh.design.proxy.handwritingproxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyselfProxy {

    private static final String WRAP = "\r\n";


    public static Object newProxyInstance(MyselfClassLoader loader,
                                          Class<?>[] interfaces,
                                          MyselfInvocationHandler h) {
        //手动生成动态代理类java文件的代码字符串
        String generateProxy = generateProxy(interfaces);
        // 获取当前文件夹的路径
        String path = MyselfProxy.class.getResource("").getPath() + "Proxy$0.java";
        FileWriter fileWriter = null;
        StandardJavaFileManager standardFileManager =  null;
        try {
            // 生成java文件
            fileWriter = new FileWriter(path);
            fileWriter.write(generateProxy);
            fileWriter.flush();

            // 编译java文件
            JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
            standardFileManager = systemJavaCompiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(path);
            JavaCompiler.CompilationTask task = systemJavaCompiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
            task.call();
            //把编译好的java文件加载到JVM中
            Class<?> proxy$0 = loader.findClass("Proxy$0");
            Constructor<?> constructor = proxy$0.getConstructor(MyselfInvocationHandler.class);
            //删除虚拟代理类
            File file = new File(path);
            file.delete();
            //  通过反射创建动态代理类
            return constructor.newInstance(h);

        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if(fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(standardFileManager!=null){
                try {
                    standardFileManager.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return null;
    }

    // 生成动态代理类的java文件
    private static String generateProxy(Class<?>[] interfaces) {

        StringBuilder spliceProxy = new StringBuilder();

        spliceProxy.append("package com.swh.design.proxy.handwritingproxy;" + WRAP + WRAP);

        spliceProxy.append("import java.lang.reflect.Method;"+WRAP);
        // 实现目标类的接口是为了生成动态代理类后能够使用目标类来接收，并可以使用目标类来调用目标类的方法
        spliceProxy.append("public class Proxy$0 implements " + interfaces[0].getName() + " {" + WRAP);
        spliceProxy.append("private MyselfInvocationHandler h;" + WRAP);
        spliceProxy.append("public Proxy$0(MyselfInvocationHandler h){" + WRAP);
        spliceProxy.append("this.h=h;}" + WRAP);


        Method[] methods = interfaces[0].getMethods();

        for (Method method : methods) { // 循环处理目标类的中方法 进行代理，并实现接口中的方法进行重写
            spliceProxy.append("public " + method.getReturnType().getName() + " " + method.getName() + "(){" + WRAP);
            spliceProxy.append("try{"+WRAP);
            spliceProxy.append("Method m=" + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{});" + WRAP);
            // 调用JdkProxy类的invoke 方法 ，invoke方法加上额外功能后调用目标类的方法
            spliceProxy.append("this.h.invoke(this,m,null);" + WRAP);
            spliceProxy.append("}catch (Throwable e) {"+WRAP);
            spliceProxy.append("e.printStackTrace();"+WRAP);
            spliceProxy.append("}"+WRAP);
            spliceProxy.append("}" + WRAP);


        }
        spliceProxy.append("}" + WRAP);


        return spliceProxy.toString();


    }

}
