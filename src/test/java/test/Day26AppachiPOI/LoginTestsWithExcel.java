package test.Day26AppachiPOI;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import test.TestBase;
import utils.Driver;
import utils.ExcelUtil;

import java.util.Map;

public class LoginTestsWithExcel extends TestBase {

    @Test(dataProvider = "credentials", description = "login with different credentials")
    public void loginTest(String username, String password, String firstname, String lastname, String result){

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

        if(Driver.get().getTitle().equalsIgnoreCase("Dashboard")){
            System.out.println("Test passed");
        }else{
            System.out.println("Test is not passed ");
        }

       // Assert.assertEquals(Driver.get().getTitle(), "Dashboard");
    }





    //
    //
    @DataProvider(name = "credentials")
   public static Object[][] credentials(){
        ExcelUtil qa2 = new ExcelUtil("vytrack_testusers.xlsx", "QA2-short");
        return qa2.getDataArray();

   }











//    public static void main(String[] args) {
//
//        ExcelUtil qa2 = new ExcelUtil("vytrack_testusers.xlsx", "QA2-short");
//        System.out.println("Row count: " + qa2.rowCount());
//        System.out.println(qa2.getColumnsNames());
//
//        // map is a data structor every value is referenced by key
//        // When we retrieve data from map, we do not need specify index, we specify key name
//        // keys must be uniqe
//        // keys are represented by column names
//        for(Map<String, String> map: qa2.getDataList()){
//            System.out.println(map.get("username"));
//
//        }


 //   }


}
