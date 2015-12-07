package HelloWorld;

import CustomWorld.CustomWorld;

/**
 * Integração de Sistemas
 * Pedro Filipe Dinis Stamm de Matos, 2009116927
 */
public class HelloWorld {

    public void sayHi(){
        System.out.println("Herrow");
    }

    public void sayThis(String text){
        CustomWorld c = new CustomWorld(text);
        c.say();
        c.sayCustom(text+"random");
    }

    private void sayBye(){
        System.out.println("Buhbye");
    }
}
