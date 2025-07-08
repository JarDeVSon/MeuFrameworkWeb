package steps;

import core.Browser;
import core.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Hooks {
    /*
    Abrir o navegador escolhido, de acordo com os cenários correspondentes
     */
    @Before
    public void openBrowser(Scenario scenario) {
        Driver.setNameScenario(scenario.getName());
        new Driver(Browser.CHROME); // Initialize driver for this thread
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
            // Save screenshot to file so Cluecumber can embed it
            // 1. Take the screenshot
            byte[] screenshotBytes =
                    ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            // 2. Build a safe file name and path
            String safeName = scenario.getName().replaceAll("[^A-Za-z0-9._-]", "_") + ".png";
            Path screenshotPath = Paths.get("report", "attachments", safeName);

            // 3. Write it to disk for Cluecumber
            try {
                Files.createDirectories(screenshotPath.getParent());   // create folders if missing
                Files.write(screenshotPath, screenshotBytes);          // save the PNG
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 4. (Optional) attach it to the Cucumber JSON
            scenario.attach(screenshotBytes, "image/png", safeName);
        }

        Driver.quitDriver();

    }
}
