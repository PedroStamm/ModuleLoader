package Plugin;

/**
 * Integração de Sistemas
 * Pedro Filipe Dinis Stamm de Matos, 2009116927
 */
public class Plugin {
    private String serverClass;
    private String botClass;
    private String command;
    private Class classRef;

    public String getServerClass() {
        return serverClass;
    }

    public void setServerClass(String serverClass) {
        this.serverClass = serverClass;
    }

    public String getBotClass() {
        return botClass;
    }

    public void setBotClass(String botClass) {
        this.botClass = botClass;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Class getClassRef() {
        return classRef;
    }

    public void setClassRef(Class classRef) {
        this.classRef = classRef;
    }
}
