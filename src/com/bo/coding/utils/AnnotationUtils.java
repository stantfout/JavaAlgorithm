package com.bo.coding.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class AnnotationUtils {

    /**
     * 获取拥有该注解的所有类
     * @param annotationClass
     * @return
     */
    public static Set<Class<?>> getClassByAnnotation(Class<? extends Annotation> annotationClass) {
        Set<Class<?>> result = new HashSet<>();
        try {
            // 获取包名下所有类
            Set<Class<?>> classes = getClasses("com");
            for(Class c:classes) {
                if(c.isAnnotationPresent(annotationClass)){
                    result.add(c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据包名获取类
     * @param packName
     * @return
     */
    public static Set<Class<?>> getClasses(String packName) {
        Set<Class<?>> classes = new HashSet<>();

        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packName);
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");

                    findClassesInPackageByFile(packName, filePath, true, classes);
                } else if ("jar".equals(protocol)) {
                    JarFile jar;
                    
                    jar = ((JarURLConnection) url.openConnection()).getJarFile();
                    Enumeration<JarEntry> entries = jar.entries();
                    String packageDirName = packName.replace('.', '/');
                    findClassesInPackageByJar(packName, entries, packageDirName, true, classes);
                }
            
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return classes;
    }

    private static void findClassesInPackageByJar(String packName, Enumeration<JarEntry> entries, String packageDirName,
            boolean recursive, Set<Class<?>> classes) {
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String name = entry.getName();
            if (name.charAt(0) == '/') {
                name = name.substring(1);
            }

            if (name.startsWith(packageDirName)) {
                int index = name.lastIndexOf('/');

                if (index != -1) {
                    packName = name.substring(0, index).replace('/', '.');
                }

                if (index != - 1 || recursive) {
                    if (name.endsWith(".class") && !entry.isDirectory()) {
                        String className = name.substring(packName.length() + 1, name.length() - 6);

                        try {
                            classes.add(Class.forName(packName + '.' + className));
                        } catch (ClassNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static void findClassesInPackageByFile(String packName, String filePath, boolean recursive, Set<Class<?>> classes) {
        File dir = new File(filePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }

        File[] dirFiles = dir.listFiles(new FileFilter() {

            @Override
            public boolean accept(File f) {
                return (recursive && f.isDirectory()) || f.getName().endsWith(".class");
            }
            
        });

        for (File file : dirFiles) {
            if (file.isDirectory()) {
                findClassesInPackageByFile(packName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
            } else {
                String className = file.getName().substring(0, file.getName().length() - ".class".length());
                
                try {
                    classes.add(Thread.currentThread().getContextClassLoader().loadClass(packName + '.' + className));
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
