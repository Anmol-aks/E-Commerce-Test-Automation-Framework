package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.LoginPage;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LoginTest extends BaseTest {

    // This is the data provider method that reads from the CSV
    @DataProvider(name = "loginDataFromCSV")
    public Object[][] provideLoginData() throws IOException, CsvException {
        // Path to the CSV file
        String csvFile = "src/test/resources/login-data.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> allData = reader.readAll();
            // Remove the header row
            allData.remove(0);
            return allData.toArray(new Object[0][0]);
        }
    }

    // This single test will run for every row in the CSV file
    @Test(dataProvider = "loginDataFromCSV")
    public void testAllLoginScenarios(String username, String password, String expectedResult, String errorMessage) {
        // Navigate to the site for each test run
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);

        // Perform the login using data from the CSV
        loginPage.loginToApplication(username, password);

        // Check the expected result from the CSV
        if (expectedResult.equalsIgnoreCase("success")) {
            // If success is expected, assert that the URL changes to the inventory page
            String expectedUrl = "https://www.saucedemo.com/inventory.html";
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, expectedUrl, "Successful login did not lead to the inventory page.");
        } else {
            // If failure is expected, assert that the error message is correct
            String actualError = loginPage.getErrorMessage();
            Assert.assertTrue(actualError.contains(errorMessage), "Error message was not as expected.");
        }
    }
}