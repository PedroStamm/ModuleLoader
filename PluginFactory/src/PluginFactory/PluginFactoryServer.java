package PluginFactory;

import Plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * Integração de Sistemas
 * Pedro Filipe Dinis Stamm de Matos, 2009116927
 */
public class PluginFactoryServer extends PluginFactory {
    public Plugin loadClass(File filestream) throws IOException {
        {
            JarFile jarFile = new JarFile(filestream);
            Enumeration e = jarFile.entries();
            URL[] urls = { filestream.toURI().toURL() };
            URLClassLoader cl = URLClassLoader.newInstance(urls);

            Manifest man = jarFile.getManifest();
            Attributes a = man.getMainAttributes();
            Plugin p = new Plugin();
            p.setClassName(a.getValue("Server-Class"));
            while(e.hasMoreElements()){
                JarEntry je = (JarEntry) e.nextElement();
                if(je.isDirectory() || !je.getName().endsWith(".class") || !je.getName().replace('/','.').contains(p.getClassName())){
                    continue;
                }
                try {
                    p.setClassRef(cl.loadClass(p.getClassName()));
                    return p;
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
            return null;
        }
    }
}
