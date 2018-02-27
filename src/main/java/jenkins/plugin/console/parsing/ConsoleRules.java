package jenkins.plugin.console.parsing;

public class ConsoleRules {

    private String name = null;
    private String path = null;

    public ConsoleRules() {
        // Empty constructor
    }

    public ConsoleRules(final String name, final String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setPath(final String path) {
        this.path = path;
    }

}
