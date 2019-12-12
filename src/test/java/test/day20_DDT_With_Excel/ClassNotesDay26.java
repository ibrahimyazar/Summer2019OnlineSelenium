package test.Day26_AppachiPOI;

public class ClassNotesDay26 {

    // vytrack_testusers.xlsx we added with drag and drop on the Summer2019OnlinetestNGSSeleniumProject files
    /*
    we added new dependedcysy for apache
    <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>4.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>4.0.1</version>
        </dependency>

        CREATED NEW     file name excel utils in the utils packege



     */

    /*
    Agenda: DDT or Data Driven Testing with Data Provider and Apache POI

	Apache POI it's a java library that helps to work with excel files.

	Why it's important to know this library?

	Excel file is very popular way to store data. It can contains thousands of rows and columns with data.
	 In order to retrieve and inject that data with java we use Apache POI library.
	In testing, excel files are very common for storing test data.

	Excel file can be used as a source of test data in automation.

	############################

	DDT Data-driven testing is a software testing methodology.
	The idea is to retrieve test data from outside.
	We don't want to store test data in variables.
	Instead, we want to be able to change test data without affecting test script.
	When application requires testing with multiple data inputs we can use Data Driven Framework.

	What does it mean "Test data hard coded?"  video day 26 2:02

	loginPage.login("storemanager85", "UserUser123");
	instead of this
	loginPage.login(excel.getUsername("storemanager"), excel.getPassword("storemanager"));

	Data Driven Testing - test data drives test

	Test and test data is separately

	Changes in test data shouldn't require changes in code.

####If file name is red, that means file is not staged in git.

In TestNG we can run same test multiple times with @DataProvider. IF we combine data provider with excel file, then we can run same test multiple times with data that is coming from excel file.

If you see "?" next to excel file, probably you don't have any excel program on computer,
or Intellij cannot recognize it yet.

$ - means temp file. When you open excel file, excel will create temp file automatically.


     */

}
