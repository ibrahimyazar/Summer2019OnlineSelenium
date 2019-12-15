package test.day22_Review;

import org.testng.annotations.Test;
import utils.ExcelUtil;

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


    }
}
