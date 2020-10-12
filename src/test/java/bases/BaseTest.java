package bases;

import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ExtentReportUtils;
import java.lang.reflect.Method;
import static pages.CartPage.fecharModal;
import static utils.DriverFactory.createDriver;
import static utils.DriverFactory.killDriver;

public class BaseTest {
    @BeforeSuite
    public static void beforeSuite(){
        ExtentReportUtils.createReport();
    }

    @BeforeMethod
    public void setUp(Method testMethod){
        ExtentReportUtils.addTest(testMethod.getName(), testMethod.getDeclaringClass().getSimpleName());
        createDriver("chrome");
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        ExtentReportUtils.addTestResult(testResult);
        fecharModal();
        killDriver();
    }

    @AfterClass
    public static void afterClass(){
        ExtentReportUtils.generateReport();
    }
}