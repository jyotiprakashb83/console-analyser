package jenkins.plugin.console.parsing;

import java.util.HashMap;

public class ConsoleConstantsDisplay {

    final private HashMap<String, String> colorTable = new HashMap<String, String>();
    final private HashMap<String, String> iconTable = new HashMap<String, String>();
    final private HashMap<String, String> linkListDisplay = new HashMap<String, String>();
    final private HashMap<String, String> linkListDisplayPlural = new HashMap<String, String>();

    public ConsoleConstantsDisplay() {
        // Color of each status
        colorTable.put(ConsoleConstants.ERROR, "red");
        colorTable.put(ConsoleConstants.WARNING, "orange");
        colorTable.put(ConsoleConstants.INFO, "blue");
        colorTable.put(ConsoleConstants.START, "blue");

        // Icon for each status in the summary
        iconTable.put(ConsoleConstants.ERROR, "red.gif");
        iconTable.put(ConsoleConstants.WARNING, "yellow.gif");
        iconTable.put(ConsoleConstants.INFO, "blue.gif");

        // How to display in link summary html
        linkListDisplay.put(ConsoleConstants.ERROR, "Error");
        linkListDisplay.put(ConsoleConstants.WARNING, "Warning");
        linkListDisplay.put(ConsoleConstants.INFO, "Info");

        linkListDisplayPlural.put(ConsoleConstants.ERROR, "Errors");
        linkListDisplayPlural.put(ConsoleConstants.WARNING, "Warnings");
        linkListDisplayPlural.put(ConsoleConstants.INFO, "Infos");
    }

    public HashMap<String, String> getColorTable() {
        return colorTable;
    }

    public HashMap<String, String> getIconTable() {
        return iconTable;
    }

    public HashMap<String, String> getLinkListDisplay() {
        return linkListDisplay;
    }

    public HashMap<String, String> getLinkListDisplayPlural() {
        return linkListDisplayPlural;
    }

}
