package jenkins.plugin.console.parsing;

public class ConsolePart {

    private String[] lines;
    private int logPartNum;

    // Intentional - first object is created, then fields are set later on.
    public ConsolePart() {
    }

    public String[] getLines() {
        return lines;
    }

    public void setLines(final String[] lines) {
        this.lines = lines;
    }

    public int getLogPartNum() {
        return logPartNum;
    }

    public void setLogPartNum(final int logPartNum) {
        this.logPartNum = logPartNum;
    }

    public boolean isEmpty() {
        return (lines[0] == null);
    }

}
