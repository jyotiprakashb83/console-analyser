package jenkins.plugin.console.action;

import hudson.model.Action;
import jenkins.plugin.console.parsing.ConsoleAction;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

/**
 * By Jyoti Prakash.
 */
public class ConsoleProjectAction implements Action {

    public final AbstractProject<?,?> project;

    public ConsoleProjectAction(AbstractProject<?, ?> project) {
        this.project = project;
    }

    public String getIconFileName() {
        return null;
    }

    public String getDisplayName() {
        return "logparser";
    }

    public String getUrlName() {
        return "logparser";
    }

    public ConsoleAction getLastLogParserAction() {
        final AbstractBuild<?,?> tb = project.getLastSuccessfulBuild();

        AbstractBuild<?,?> b = project.getLastBuild();
        while (b != null) {
            ConsoleAction a = b.getAction(ConsoleAction.class);
            if (a != null) {
                return a;
            }
            if (b == tb) {
                // if even the last successful build didn't produce the test result,
                // that means we just don't have any tests configured.
                return null;
            }
            b = b.getPreviousBuild();
        }

        return null;
    }

    public void doTrend(StaplerRequest req, StaplerResponse rsp) throws IOException, ServletException {
        ConsoleAction a = this.getLastLogParserAction();
        if (a != null) {
            a.doGraph(req, rsp);
        } else {
            rsp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void doTrendMap( StaplerRequest req, StaplerResponse rsp) throws IOException, ServletException {
        ConsoleAction a = this.getLastLogParserAction();
        if (a != null) {
            a.doGraphMap(req, rsp);
        } else {
            rsp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
