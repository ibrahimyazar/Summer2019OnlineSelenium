package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.ConfigurationReader;
import utils.Driver;

import javax.naming.ldap.ExtendedRequest;

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
     protected ExtentReports extentReports;
    /*
     * The ExtentHtmlReporter creates a rich standalone HTML file. It allows several
     * configuration options via the <code>config()</code> method.
     */
    protected ExtentHtmlReporter extentHtmlReporter;  // this is an object   / generate report
    //  Defines a test. You can add logs, snapshots, assign author and categories to a test and its children.
    protected ExtentTest extentTest;                  // this is an object / write the report

    @BeforeTest
    public void beforeTest(){   // this report you doing just one and use forever
        // location of report it is going to next to tartget folder, test-output folder
        String filePath = System.getProperty("user.dir") + "/test-output/report.html";
        extentReports = new ExtentReports();
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setReportName("Vytrack Test Result");
        extentReports.setSystemInfo("Enviroment", "QA1");
        extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @AfterTest
    public void afterTest(){
        extentReports.flush();
    }


    /// test base a supper class all the test classes
    @BeforeMethod
    public void setUp(){
        String url = ConfigurationReader.getProperty("url");
        Driver.get().get(url);
        //  Driver.get().get(ConfigurationReader.getProperty("url"));
    }

    @AfterMethod
    public void teardown(){
        Driver.close();
    }
}
