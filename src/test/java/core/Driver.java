package core;

import com.deque.axe.AXE;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    /*
        O pacote core com as classes Driver e Browser são responsáveis por todas as configurações
        do navegador
     */
    private static final URL scriptUrl = Driver.class.getResource("/axe.min.js");

    public static URL getScriptUrl() {
        return scriptUrl;
    }

    private static WebDriver driver; //get
    private static WebDriverWait wait;
    private static String nameScenario; //setter
    private static File directory;
    private static int numPrint;

    /*
    Construtor que vai iniciar o navegador selecionado
     */
    public Driver(Browser browser) {
        switch (browser) {
            case CHROME:
                startChrome();
                break;
            case FIREFOX:
                startFirefox();
                break;
        }
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

        JSONObject responseJson = new AXE.Builder(Driver.getDriver(),Driver.getScriptUrl()).analyze();
        JSONArray violations = responseJson.getJSONArray("violations");
        if (violations.length()==0){
            System.out.println("No errors");
        } else {
            AXE.writeResults("Acessibility Violations Report", responseJson);
            System.out.println(AXE.report(violations));
        }

    }

    /*
    Criar pastas com os nomes dos cenários de execução automatizados
     */
    public static void makeDirectory() {
        String path = "target/report/attachments";
        directory = new File(path + "/" + nameScenario);
        directory.mkdir();
        numPrint = 0;
    }

    /*
    Criar as evidencias enumeradas com os passos de execução automatizados
     */
    public static void printScreenshot(String steps) throws IOException {
        numPrint++;
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = directory.getPath() + "/" + numPrint + " - " + steps + ".png";
        FileUtils.copyFile(file, new File(path));
    }

    /*
    Estratégia para detectar os elementos presentes na tela (Evitar o no such element)
     */
    public static void visibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void elementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /*
    Acessores do inicio do escopo ( ALT+INSERT setter)
     */
    public static void setNameScenario(String nameScenario) {
        Driver.nameScenario = nameScenario;
    }

    /*
    Acessores do inicio do escopo ( ALT+INSERT getter)
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /*
    Instanciar o Firefox
     */
    private void startFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    /*
    Instanciando o Chrome com headless ( 2ª plano)
     */
    private void startChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
    }


}