package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static utils.DriverFactory.getDriver;

public class GeneralUtils {

    public static String getDataHoraAtual() {
        DateFormat f24h = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        return f24h.format(new Date());
    }

    public String getNameScreenshot(String nameTest, String pathScreenshot) {
        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String nameScreenshot = nameTest + " - " + getDataHoraAtual() + ".png";
        String filePath = pathScreenshot + nameScreenshot;
        try {
            FileUtils.copyFile(file, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nameScreenshot;
    }

    public static String getProjectPath(){
        return System.getProperty("user.dir");
    }

    public static String getMethodNameByLevel(int level){
        return Thread.currentThread().getStackTrace()[level].getMethodName();
    }
}