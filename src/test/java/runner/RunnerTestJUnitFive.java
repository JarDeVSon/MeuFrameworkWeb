package runner;


import org.junit.jupiter.api.AfterAll;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import java.io.IOException;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, json:target/report/cucumber.json")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@regressivo")
@ConfigurationParameter(key = JUNIT_PLATFORM_NAMING_STRATEGY_PROPERTY_NAME, value = "long")
public class RunnerTestJUnitFive {

    @AfterAll
    public static void report() throws IOException {
        if (System.getProperty("os.name").equals("Windows 10")) {
            Runtime.getRuntime().exec("cmd.exe /c mvn cluecumber-report:reporting");
        } else {
            Runtime.getRuntime().exec("sh -c mvn cluecumber-report:reporting");

        }
    }

}
