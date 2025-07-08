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
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static final URL scriptUrl = Driver.class.getResource("/axe.min.js");
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
    private static final ThreadLocal<String> nameScenario = new ThreadLocal<>();
    private static final ThreadLocal<File> directory = new ThreadLocal<>();
    private static final ThreadLocal<Integer> numPrint = new ThreadLocal<>();

    public static URL getScriptUrl() {
        return scriptUrl;
    }

    public Driver(Browser browser) {
        switch (browser) {
            case CHROME:
                startChrome();
                break;
            case FIREFOX:
                startFirefox();
                break;
        }

        // Initialize per-thread objects
        wait.set(new WebDriverWait(getDriver(), 10));
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        runAccessibilityCheck();
    }

    private void runAccessibilityCheck() {
        try {
            JSONObject responseJson = new AXE.Builder(getDriver(), getScriptUrl()).analyze();
            JSONArray violations = responseJson.getJSONArray("violations");
            if (violations.length() == 0) {
                System.out.println("[" + Thread.currentThread().getId() + "] No accessibility errors");
            } else {
                AXE.writeResults("Acessibility_Violations_Report_" + Thread.currentThread().getId(), responseJson);
                System.out.println(AXE.report(violations));
            }
        } catch (Exception e) {
            System.err.println("Accessibility check failed: " + e.getMessage());
        }
    }

    public static void makeDirectory() {
        String path = "target/report/attachments";
        File scenarioDir = new File(path + "/" + getNameScenario());
        scenarioDir.mkdirs();
        directory.set(scenarioDir);
        numPrint.set(0);
    }

    public static void printScreenshot(String steps) throws IOException {
        int currentNum = numPrint.get() + 1;
        numPrint.set(currentNum);

        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String path = directory.get().getPath() + "/" + currentNum + " - " + steps + ".png";
        FileUtils.copyFile(file, new File(path));
    }

    public static void visibilityOf(WebElement element) {
        wait.get().until(ExpectedConditions.visibilityOf(element));
    }

    public static void elementToBeClickable(WebElement element) {
        wait.get().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void setNameScenario(String scenarioName) {
        nameScenario.set(scenarioName);
    }

    public static String getNameScenario() {
        return nameScenario.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            wait.remove();
            nameScenario.remove();
            directory.remove();
            numPrint.remove();
        }
    }

    private void startFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-dev-shm-usage");
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--ignore-certificate-errors");
        firefoxOptions.addArguments("--disable-popup-blocking");
        firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("--incognito");

        driver.set(new FirefoxDriver(firefoxOptions));
    }

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
        chromeOptions.addArguments("--disable-gpu");

        driver.set(new ChromeDriver(chromeOptions));
    }
}