package test.day7_Annotaion_Css_Multiple_TestNG;

import org.testng.annotations.*;

public class AnnotationTest {

    @BeforeClass
    public void BeforeClass(){
        System.out.println("Before Class");  // runs only once
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("After Class");  // runs only once
    }

    @BeforeMethod
    public void setup(){
        // code will be running before every test
        // we can use method before method
        System.out.println("Before method");
    }

    @Test
    public void tets1(){
        System.out.println("test 1");
    }
    @Test
    public void tets2(){
        System.out.println("test 2");
    }
    @Test
    public void tets3(){
        System.out.println("test 3");
    }

    @AfterMethod
    public void a(){
        // code will be running before every test
        // we can use method before method
        System.out.println("After method");
        System.out.println("---------------");
    }
    /*  we csn write whatever we want
    @BeforeMethod
    public void setup(){
        // code will be running before every test
        // we can use method before method
        System.out.println("Before method");
    }

     */


}
