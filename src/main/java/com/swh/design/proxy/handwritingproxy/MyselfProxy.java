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

        String generateProxy = generateProxy(interfaces);

        String path = MyselfProxy.class.getResource("").getPath() + "Proxy$0.java";
        String path1 = "E:\\design_patterns\\design_patterns\\src\\main\\java\\com\\swh\\design\\proxy\\handwritingproxy\\Proxy$0.java";
        FileWriter fileWriter = null;
        StandardJavaFileManager standardFileManager =  null;
        try {
            // 生成java文件
            fileWriter = new FileWriter(path);
            fileWriter.write(generateProxy);
            fileWriter.flush();
            fileWriter.close();
            FileWriter fileWriter1 = new FileWriter(path1);
            fileWriter1.write(generateProxy);
            fileWriter1.flush();
            fileWriter1.close();
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
            return constructor.newInstance();

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

    private static String generateProxy(Class<?>[] interfaces) {

        StringBuilder spliceProxy = new StringBuilder();

        spliceProxy.append("package com.swh.design.proxy.handwritingproxy;" + WRAP + WRAP);

        spliceProxy.append("import java.lang.reflect.Method;"+WRAP);

        spliceProxy.append("public class Proxy$0 implements " + interfaces[0].getName() + " {" + WRAP);
        spliceProxy.append("private MyselfInvocationHandler h;" + WRAP);
        spliceProxy.append("public Proxy$0(MyselfInvocationHandler h){" + WRAP);
        spliceProxy.append("this.h=h;}" + WRAP);


        Method[] methods = interfaces[0].getMethods();

        for (Method method : methods) {
            spliceProxy.append("public " + method.getReturnType().getName() + " " + method.getName() + "(){" + WRAP);
            spliceProxy.append("try{"+WRAP);
            spliceProxy.append("Method m=" + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{});" + WRAP);
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
