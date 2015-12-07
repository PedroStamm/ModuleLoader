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
public abstract class PluginFactory {
    //comment
    //The heavy-lifting. A class recebe uma string com o nome do ficheiro/classe
        abstract Plugin loadClass(File filestream) throws IOException ;
}
