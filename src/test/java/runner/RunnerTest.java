package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {"pretty", "json:target/report/cucumber.json"},
        tags = "@regressivo"

)
public class RunnerTest {
    /*
  Depois da execução de todos os testes, gerar o relatório de execução de acordo
  com o sistema operacional (Windows ou Linux, tb pensei nisso, te amo linux)
   */
    @AfterClass
    public static void reports() throws IOException {
        if (System.getProperty("os.name").equals("Windows 10")) {
            Runtime.getRuntime().exec("cmd.exe /c mvn cluecumber-report:reporting");
        } else {
            Runtime.getRuntime().exec("sh -c mvn cluecumber-report:reporting");

        }
    }
}
