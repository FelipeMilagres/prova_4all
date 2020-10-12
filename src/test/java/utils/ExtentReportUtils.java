package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.ITestResult;
import java.io.IOException;

public class ExtentReportUtils {
    public static ExtentReports extentReports = null;
    public static ExtentTest test;
    static String reportPath = "src/test/resources/reports/";
    static String reportNane = "Prova 4all" + " _ " + GeneralUtils.getDataHoraAtual();
    static String fileName = reportNane  + ".html";
    static String nameTest;

    public static void createReport() {
        if (extentReports == null) {
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath +  fileName);
            extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReporter);
        }
    }

    public static void addTest(String name, String testCategory) {
        nameTest = name;
        test = extentReports.createTest(nameTest).assignCategory(testCategory.replace("Tests",""));
    }

    public static void addTestInfo(int methodLevel, String text) {
        try {
            test.log(Status.PASS, "METHOD: " + GeneralUtils.getMethodNameByLevel(methodLevel) + "  ||  ACTION: " + text, getScreenshotMedia());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MediaEntityModelProvider getScreenshotMedia() throws IOException {
        String screenshotPath = new GeneralUtils().getNameScreenshot(nameTest, reportPath+"screenshots/");
        return MediaEntityBuilder.createScreenCaptureFromPath("screenshots/" + screenshotPath).build();
    }

    public static void addTestResult(ITestResult testResult){
        String message = testResult.getThrowable() == null ? "" : testResult.getThrowable().getMessage();
        String stacktrace = testResult.getThrowable() == null ? "" : ExceptionUtils.getStackTrace(testResult.getThrowable());

        try{
            switch (testResult.getStatus()){
                case ITestResult.SUCCESS:
                    test.log(Status.PASS, "Test Result: " + Status.PASS, getScreenshotMedia());
                    break;
                case ITestResult.FAILURE:
                    test.log(Status.FAIL, "Test Result: " + Status.FAIL + "<pre>" + "Message: " + message +  "</pre>" + "<pre>" + "Stack Trace: " + stacktrace + "</pre>", getScreenshotMedia());
                    break;
                case ITestResult.SKIP:
                    test.log(Status.SKIP, "Test Result: " + Status.SKIP + "<pre>" + "Message: " + message +  "</pre>" + "<pre>" + "Stack Trace: " + stacktrace + "</pre>", getScreenshotMedia());
                    break;
                case ITestResult.SUCCESS_PERCENTAGE_FAILURE:
                    test.log(Status.WARNING, "Test Result: " + Status.WARNING + "<pre>" + "Message: " + message +  "</pre>" + "<pre>" + "Stack Trace: " + stacktrace + "</pre>", getScreenshotMedia());
                    break;
            }
        } catch (IOException e){
            e.getMessage();
        }
    }

    public static void generateReport() {
        extentReports.flush();
    }
}