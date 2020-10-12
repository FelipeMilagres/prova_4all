package pages;

import bases.BaseMethod;
import org.openqa.selenium.WebDriver;

public class BasePage  extends BaseMethod {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
}
