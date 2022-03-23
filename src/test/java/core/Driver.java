package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Driver {
    /*
        O pacote core com as classes Driver e Browser são responsáveis por todas as configurações
        do navegador
     */
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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        boolean headless = Boolean.parseBoolean(System.getProperty("headless"));
        chromeOptions.setHeadless(headless);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().setSize(new Dimension(1280, 720));
    }


}