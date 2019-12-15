package Vy_Track;

import org.testng.annotations.Test;
import pages.CreateCarPage;
import pages.LoginPage;
import pages.VehiclesPage;
import test.TestBase;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.ExcelUtil;

import java.util.List;
import java.util.Map;

public class CreateCarTest extends TestBase {

    @Test(description = "Create car by readng test data from excel file ")
    public void createCarTest(){

        extentTest = extentReports.createTest("Create car by readng test data from excel file");
        LoginPage loginpage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();
        CreateCarPage createCarPage = new CreateCarPage();

        // reading username configration
        String userName = ConfigurationReader.getProperty("User_name");  // clikg and hold commend button and mause hareket ettir
        String password = ConfigurationReader.getProperty("Password");

        // to login
        loginpage.login(userName, password);
        //we have to navigate to fleet vehicle
        loginpage.navigateTo("Fleet", "Vehicles");

        loginpage.waitUntilLoaderMaskDisappear();

        vehiclesPage.clickToCreateACar();

        loginpage.waitUntilLoaderMaskDisappear();

        // we need to enter test data new information for new car from excel
        ExcelUtil excelUtil = new ExcelUtil("Cars.xlsx", "Cars");
        //read data from excel spreadsheet as list of map
        //testData it's just reference variable
        List<Map<String, String>> testData = excelUtil.getDataList();
        //0 means data from first row, License Plate it's a column name
        //so we are reading from first row and License Plate column
        createCarPage.licensePlateElement.sendKeys(testData.get(0).get("License Plate"));
        //enter driver info
        createCarPage.driverElement.sendKeys(testData.get(0).get("Driver"));
        //enter model year
        createCarPage.driverElement.sendKeys(testData.get(0).get("Model Year"));
        //enter color
        createCarPage.driverElement.sendKeys(testData.get(0).get("Color"));

        loginpage.waitUntilLoaderMaskDisappear();
        BrowserUtils.wait(10);
        createCarPage.saveAndCloseButtonElement.click();

        extentTest.info("Created new car");

    }


}
