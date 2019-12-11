package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

import javax.naming.ldap.ExtendedRequest;
import java.io.IOException;

/// test base a supper class all the test classes
//this class will be a test foundation for all test classes
//we will put here only before and after parts
//In this way before and after methods will be the same
//Every test class will extend testbase class
public abstract class TestBase {

    // before crating this report class we dowloanded dependies extend to in the pom file

    /*
     * The ExtentReports report client for starting reporters and building reports. For most applications,
     * you should have one ExtentReports instance for the entire JVM.
     * ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
     * ExtentXReporter extentx = new ExtentXReporter("localhost");
     */
     protected static ExtentReports extentReports;
    /*
     * The ExtentHtmlReporter creates a rich standalone HTML file. It allows several
     * configuration options via the <code>config()</code> method.
     */
    protected static ExtentHtmlReporter extentHtmlReporter;  // this is an object   / generate report
    //  Defines a test. You can add logs, snapshots, assign author and categories to a test and its children.
    protected static ExtentTest extentTest;                  // this is an object / write the report

    //parameteres name  = "test" value = "regrestion
    @BeforeTest
    @Parameters({"test", "env_url"})
    public void beforeTest(@Optional String test, @Optional String env_url){   // this report you doing just one and use forever
        // location of report it is going to next to tartget folder, test-output folder
        //location of report
        //it's gonna be next to target folder, test-output folder
        String reportName = "report";  // day 25 video 1:30
        if (test != null) {
            reportName = test;
        }
        String filePath = System.getProperty("user.dir") + "/test-output/" + reportName + ".html";
        //String filePath = System.getProperty("user.dir") + "/test-output/report.html";
        extentReports = new ExtentReports();
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setReportName("Vytrack Test Result");
        //system information
        String env = ConfigurationReader.getProperty("url");   // for xml
        if (env_url != null) {
            env = env_url;
        }
        extentReports.setSystemInfo("Enviroment", env);  // we changed day 25 video 2:10
        extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @AfterTest
    public void afterTest(){
        extentReports.flush();
    }



    @BeforeMethod
    @Parameters("env_url")
    public void setUp(@Optional String env_url){
        String url = ConfigurationReader.getProperty("url");
        //if name parameter was set, then use it
        //if it's null that means it was not set
        if(env_url != null){
            url = env_url;
        }
        Driver.get().get(url);
        //  Driver.get().get(ConfigurationReader.getProperty("url"));
    }

    //ITestResult class describes the result of a test. (in TestNG)
    @AfterMethod
    public void teardown(ITestResult result){  //  ITestResult coming from testNG and

        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.fail(result.getName());
            extentTest.fail(result.getThrowable());
            try {
                // returns taks screenshots and returns location of that
                extentTest.addScreenCaptureFromPath(BrowserUtils.getScreenshot(result.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(result.getStatus() == ITestResult.SKIP){
            extentTest.skip("Test case was skipped: " + result.getName());
        }

        Driver.close();
    }



}
