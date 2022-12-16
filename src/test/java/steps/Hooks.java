package steps;

import core.Browser;
import core.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.IOException;



public class Hooks {
    /*
    Abrir o navegador escolhido, de acordo com os cenários correspondentes
     */
    @Before
    public void openBrowser(Scenario scenario) {
        new Driver(Browser.CHROME);
        Driver.setNameScenario(scenario.getName());
        Driver.makeDirectory();
    }

    /*
    Fechar o navegador com status da execução
     */
    @After
    public void closeBrowser(Scenario scenario) throws IOException {

        System.out.println("==========================================================");
        System.out.println("==========================================================");
        System.out.println("==========================================================");
        System.out.println("==========================================================");
        System.out.println(" | Scenario: " + scenario.getName());
        System.out.println(" | Status: " + scenario.getStatus());
        System.out.println(" | Tag: " + scenario.getSourceTagNames());
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        if (scenario.isFailed()) {
            Driver.printScreenshot("Step failed!");
        }

        Driver.getDriver().quit();

    }
}
