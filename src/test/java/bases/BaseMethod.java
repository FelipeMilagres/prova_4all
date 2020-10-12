package bases;

import org.openqa.selenium.By;
import utils.ExtentReportUtils;
import static utils.DriverFactory.getDriver;

public class BaseMethod extends ExtentReportUtils {

    public static void cliquePorId(String id){
        getDriver().findElement(By.id(id)).click();
        addTestInfo( 4,"clicar no elemento com o id: \""+id+"\"");
    }

    public static void filtrarCategoria(String categoriaId){
        getDriver().findElement(By.id("open-categories-btn")).click();
        cliquePorId(categoriaId);
    }

    public String getTextoXpath(String xpath){
        addTestInfo( 4,"capturado texto do elemento com o Xpath: \""+xpath+"\"");
        return getDriver().findElement(By.xpath(xpath)).getText();
    }

    public String getTextoId(String id){
        addTestInfo( 4,"capturado texto do elemento com o id: \""+id+"\"");
        return getDriver().findElement(By.id(id)).getText();
    }

    public static void cliquePorXpath(String xpath){
        addTestInfo( 4,"clicar no elemento com o xpath: \""+xpath+"\"");
        getDriver().findElement(By.xpath(xpath)).click();
    }
}