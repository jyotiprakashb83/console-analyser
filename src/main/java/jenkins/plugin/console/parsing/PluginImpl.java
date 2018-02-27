package jenkins.plugin.console.parsing;

import hudson.Extension;
import hudson.Plugin;

public class PluginImpl extends Plugin {

    @Extension
    public static final ConsolePublisher.DescriptorImpl LOG_PARSER_DESCRIPTOR = ConsolePublisher.DescriptorImpl.DESCRIPTOR;

    public static ConsolePublisher.DescriptorImpl getDescriptor() {
        return LOG_PARSER_DESCRIPTOR;
    }

}
