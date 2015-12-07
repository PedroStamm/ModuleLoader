package com.tests.ModuleLoader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class Main {

    //Basta correr o jar resultante disto
    public static void main(String[] args) {
        try {
            File f = new File("jars/HelloWorld.jar");
            loadClass(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //The heavy-lifting. A class recebe uma string com o nome do ficheiro/classe
    @SuppressWarnings("Duplicates")
    static void loadClass(File filestream) throws IOException {
        //Caminho para o jar, por defeito procura uma pasta /jars
        //String pathToJar = "jars/"+filename+".jar";
        JarFile jarFile = new JarFile(filestream);
        Enumeration e = jarFile.entries();
        URL[] urls = { filestream.toURI().toURL() };
        URLClassLoader cl = URLClassLoader.newInstance(urls);

        while (e.hasMoreElements()) {
            JarEntry je = (JarEntry) e.nextElement();
            System.out.println("Found entry in jar file called "+je.getName());
            if(je.isDirectory() || !je.getName().endsWith(".class")){
                continue;
            }
            // -6 because of .class
            String className = je.getName().substring(0,je.getName().length()-6);
            className = className.replace('/', '.');
            try {/*
                //Get manifest file from jar
                Manifest man = jarFile.getManifest();
                //Get attributes from jar
                Attributes a = man.getMainAttributes();
                //Find value of Main-Class attribute
                System.out.println("From Attribute: "+a.getValue("Main-Class"));
                */
                Class c = cl.loadClass(className);
                Method[] ml = c.getMethods();
                for(Method mi : ml) {
                    System.out.println(mi);
                    Class<?>[] c3 = mi.getParameterTypes();
                    for(Class<?> c4 : c3){
                        System.out.println(c.getCanonicalName());
                    }
                }
                Constructor cR = c.getConstructor(String.class);
                Object instance = cR.newInstance("This text please");
                Runnable r = (Runnable) instance;
                Thread t = new Thread(r);
                t.start();
                //Method m = c.getMethod("sayThis", String.class);
                //m.invoke(instance, "Say this bloody text");
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (NoSuchMethodException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (InvocationTargetException e1) {
                e1.printStackTrace();
            }

        }
    }
}
