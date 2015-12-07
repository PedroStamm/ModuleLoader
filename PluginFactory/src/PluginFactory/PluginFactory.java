package PluginFactory;

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
import Plugin.Plugin;

/**
 */
public class PluginFactory {
    //comment
    //The heavy-lifting. A class recebe uma string com o nome do ficheiro/classe
    @SuppressWarnings("Duplicates")
        static Plugin loadClass(File filestream) throws IOException {
        JarFile jarFile = new JarFile(filestream);
        Enumeration e = jarFile.entries();
        URL[] urls = { filestream.toURI().toURL() };
        URLClassLoader cl = URLClassLoader.newInstance(urls);

        Manifest man = jarFile.getManifest();
        Attributes a = man.getMainAttributes();
        Plugin p = new Plugin();
        Plugin.
    }
}
