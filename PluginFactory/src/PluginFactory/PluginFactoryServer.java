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
            //Open file filestream as JarFile
            JarFile jarFile = new JarFile(filestream);
            //Get EVERY SINGLE ENTRY on JAR file
            Enumeration e = jarFile.entries();
            //Convert filestream to URL
            URL[] urls = { filestream.toURI().toURL() };
            //Load class through URL. Saved me time, I'll see other ways, this seems to be most used
            URLClassLoader cl = URLClassLoader.newInstance(urls);

            //Get manifest file from JAR
            Manifest man = jarFile.getManifest();
            //Get attributes from JAR (mapped key/value pair)
            Attributes a = man.getMainAttributes();
            //create and fill Plugin object with data from manifest
            Plugin p = new Plugin();
            p.setClassName(a.getValue("Server-Class"));
            //Run through all entries in JAR
            while(e.hasMoreElements()){
                //Pop element from e and keep reference in JAR Entry
                JarEntry je = (JarEntry) e.nextElement();
                //Figure out if found entry is not directory, is a class, and is expected class
                if(je.isDirectory() || !je.getName().endsWith(".class") || !je.getName().replace('/','.').contains(p.getClassName())){
                    continue;
                }
                try {
                    //load class with URLClassLoader and save reference to object in p
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
