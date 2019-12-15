package test.day22_ReviewAndDataDrivenTest;

import org.testng.annotations.Test;
import utils.ExcelUtil;

import java.util.HashMap;
import java.util.Map;

public class ReadTestDataFromExcelFile {

    @Test
    public void Test1(){
        // first open excelutil and we have to sipecypy the file path
        ExcelUtil cars = new ExcelUtil("Cars.xlsx", "Cars");
        //to get list use getDataList
        System.out.println(cars.getDataList());
       // License Plate=Test_plates_123, Model Year=2020.0, Color=RED, Driver=Michael Schumacher
        //    Key        value            Key        value   Key value   Key      value
        // if i want to get only color
        //get(0) means get data from first row
        //get("Color") means get value of Color column, from first row
        String color = cars.getDataList().get(0).get("Color");
        System.out.println(color);
        // get only driver
        //get(0) means get data from first row
        //get("Driverr") means get value of Color column, from first row
        String driver = cars.getDataList().get(0).get("Driver");
        System.out.println(driver);
        // to get licenceP late
        String licencePlate = cars.getDataList().get(0).get("License Plate");
        System.out.println(licencePlate);
        // to get model year
        String year = cars.getDataList().get(0).get("Model Year");
        System.out.println(year);

        //instead of index we use key name
        //in list we use index, in map - key name
        //every value is referenced by key
        //key must be unique
        //we have to specify dat type of key and value
        //they can be different
        //same thing like with list: List<String>
        //map it's key=value
        //list it's index=value
        // creating map mapo is key = value
        Map<String, String> row = new HashMap<>();
        //   key     value
        // how we enter data to file
        row.put("License Plate", "9977");   // License Plate is key and  7777 is value
        row.put("Driver", "Ibrahim");
        row.put("Color", "White");
        row.put("Model Year", "2018");

        System.out.println(row.get("Driver"));
        System.out.println(row.get("Color"));


        Map<Integer, String> values = new HashMap<>();

        values.put(1, "apple");
        //Country name, Country code

        Map<String, String> countryCode = new HashMap<>();
        countryCode.put("USA", "1");
        countryCode.put("Turkey", "090");
        countryCode.put("Germany", "049");
        countryCode.put("Australia", "+036");
        countryCode.put("China", "+85");
        countryCode.put("Kazakhstan", "+7");
        countryCode.put("Ukraine", "+380");
        countryCode.put("South Korea", "+82");
        //countryCode.put("Turkey", "+90");
        countryCode.put("Uzbekistan", "+998");
        countryCode.put("Azerbaijan", "+993");

        System.out.println(countryCode.get("Turkey"));
        System.out.println(countryCode.get("USA"));

    }
}
