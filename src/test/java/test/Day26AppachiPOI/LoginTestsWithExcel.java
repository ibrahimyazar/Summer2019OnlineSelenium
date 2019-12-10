package test.Day26AppachiPOI;

import org.testng.annotations.DataProvider;
import test.TestBase;
import utils.ExcelUtil;

import java.util.Map;

public class LoginTestsWithExcel extends TestBase {

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


    }


}
