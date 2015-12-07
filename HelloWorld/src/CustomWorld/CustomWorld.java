package CustomWorld;

/**
 * Integração de Sistemas
 * Pedro Filipe Dinis Stamm de Matos, 2009116927
 */
public class CustomWorld implements Runnable{
    private String customText;

    public CustomWorld(String customtext){
        this.customText = customtext;
    }

    public void say(){
        System.out.println(this.customText);
    }

    public void sayCustom(String text){
        System.out.println(text);
    }

    @Override
    public void run() {
        System.out.println("\nRunning thread now\n");
    }
}
