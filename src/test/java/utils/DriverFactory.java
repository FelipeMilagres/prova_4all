package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import static utils.GeneralUtils.getProjectPath;

public class DriverFactory {
    protected static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriver createDriver(String browser){
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    getProjectPath() + "\\src\\test\\resources\\browserDrivers\\chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }
        else
            if (browser.equals("mozilla")){
                System.setProperty("webdriver.gecko.driver",
                        getProjectPath() + "\\src\\test\\resources\\browserDrivers\\geckodriver");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
        } else
            if (browser.equals("edge")){
                System.setProperty("webdriver.edge.driver",
                        getProjectPath() + "\\src\\test\\resources\\browserDrivers\\edgedriver");
                driver = new EdgeDriver();
                driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://shopcart-challenge.4all.com/");
        return driver;
    }

    public static void killDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}