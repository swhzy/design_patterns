package com.swh.design.proxy.handwritingproxy;

import java.io.File;

public class MyselfClassLoader extends ClassLoader{

    private File classPathFile;

    public MyselfClassLoader() {
        String path = MyselfClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(path);

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if(classPathFile==null)return null;
        String className = ClassLoader.class.getPackage().getName() + "." + name;

        File file = new File(classPathFile, name + ".class");
        if(file.exists()){


        }

        return null;
    }
}
