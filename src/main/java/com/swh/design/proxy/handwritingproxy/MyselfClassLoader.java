package com.swh.design.proxy.handwritingproxy;

import java.io.*;

/**
 *  类加载器用于加载类文件
 */
public class MyselfClassLoader extends ClassLoader {

    private File classPathFile;

    public MyselfClassLoader() {
        String path = MyselfClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(path);

    }

    /**
     *   这个方法获取编译好的动态代理.class文件 并加载到虚拟机中
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (classPathFile == null) return null;
        String className = MyselfClassLoader.class.getPackage().getName() + "." + name;

        File file = new File(classPathFile, name + ".class");
        //File file1 = new File("E:\\design_patterns\\design_patterns\\src\\main\\java\\com\\swh\\design\\proxy\\handwritingproxy\\Proxy$0.java");
        FileInputStream inIo = null;
        ByteArrayOutputStream out = null;
        try {
            if (file.exists()) {
                inIo = new FileInputStream(file);
                out = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024];
                int len;
                while ((len = inIo.read(bytes)) != -1) {
                    out.write(bytes, 0, len);
                }
                // 把.class文件加载到虚拟机中，并返回Class对象
                return defineClass(className, out.toByteArray(), 0, out.size());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inIo!=null){
                try {
                    inIo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
