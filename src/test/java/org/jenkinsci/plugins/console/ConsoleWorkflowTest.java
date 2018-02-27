package org.jenkinsci.plugins.console;

import hudson.FilePath;
import hudson.tasks.Maven;
import jenkins.plugin.console.parsing.ConsoleAction;
import jenkins.plugin.console.parsing.ConsolePublisher;

import org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import static org.junit.Assert.assertEquals;

/**
 * In this test suite we initialize the Job workspaces with a resource (maven-project1.zip) that contains a Maven
 * project.
 */
public class ConsoleWorkflowTest {

    @ClassRule
    public static JenkinsRule jenkinsRule = new JenkinsRule();

    private static Maven.MavenInstallation mavenInstallation;

    @BeforeClass
    public static void init() throws Exception {
        mavenInstallation = jenkinsRule.configureMaven3();
    }

    /**
     * Run a workflow job using {@link ConsolePublisher} and check for success.
     */
    @Test
    public void ConsolePublisherWorkflowStep() throws Exception {
        WorkflowJob job = jenkinsRule.jenkins.createProject(WorkflowJob.class, "consolePublisherWorkflowStep");
        FilePath workspace = jenkinsRule.jenkins.getWorkspaceFor(job);
        workspace.unzipFrom(getClass().getResourceAsStream("./maven-project.zip"));
        job.setDefinition(new CpsFlowDefinition(""
                        + "node {\n"
                        + "  def mvnHome = tool '" + mavenInstallation.getName() + "'\n"
                        + "  sh \"${mvnHome}/bin/mvn clean install\"\n"
                        + "  step([$class: 'ConsolePublisher', projectRulePath: 'console-rules.txt', useProjectRule: true])\n"
                        + "}\n", true)
        );
        jenkinsRule.assertBuildStatusSuccess(job.scheduleBuild2(0));
        ConsoleAction result = job.getLastBuild().getAction(ConsoleAction.class);
        assertEquals(0, result.getResult().getTotalErrors());
        assertEquals(0, result.getResult().getTotalWarnings());
        assertEquals(0, result.getResult().getTotalInfos());
    }

}
