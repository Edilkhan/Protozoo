/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.cxf.rest;

import java.io.File;
import javax.inject.Inject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.ConfigurationManager;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.options.MavenArtifactUrlReference;
import org.ops4j.pax.exam.options.MavenUrlReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import org.ops4j.pax.exam.karaf.options.KarafDistributionOption;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.karafDistributionConfiguration;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.keepRuntimeFolder;

/**
 *
 * @author wos
 */
@RunWith(PaxExam.class)
public class RestTest {

    private static Logger LOG = LoggerFactory.getLogger(RestTest.class);
    @Inject
//    protected Calculator calculator;

    @Configuration
    public Option[] config() {
        MavenArtifactUrlReference karafUrl = maven()
                .groupId("org.apache.karaf")
                .artifactId("apache-karaf")
                .version(karafVersion())
                .type("zip");
        MavenUrlReference karafStandardRepo = maven()
                .groupId("org.apache.karaf.features")
                .artifactId("standard")
                .version(karafVersion())
                .classifier("features")
                .type("xml");
        return new Option[]{
            // KarafDistributionOption.debugConfiguration("5005", true),
            karafDistributionConfiguration()
            .frameworkUrl(karafUrl)
            .unpackDirectory(new File("target/exam"))
            .useDeployFolder(false),
            keepRuntimeFolder(),
            KarafDistributionOption.features(karafStandardRepo, "scr"),
            mavenBundle()
            .groupId("org.ops4j.pax.exam.samples")
            .artifactId("pax-exam-sample8-ds")
            .versionAsInProject().start()};
    }

    public static String karafVersion() {
        ConfigurationManager cm = new ConfigurationManager();
        String karafVersion = cm.getProperty("pax.exam.karaf.version", "3.0.0");
        return karafVersion;
    }

    @Test
    public void testAdd() {
  //      int result = calculator.add(1, 2);
  //      LOG.info("Result of add was {}", result);
    //    Assert.assertEquals(3, result);
    }
}
