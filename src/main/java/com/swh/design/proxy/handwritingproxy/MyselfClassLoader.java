package com.swh.design.proxy.handwritingproxy;

import java.io.*;

public class MyselfClassLoader extends ClassLoader {

    private File classPathFile;

    public MyselfClassLoader() {
        String path = MyselfClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(path);

    }

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
