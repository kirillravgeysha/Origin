package com.it_academy.test;

import com.it_academy.framework.DriverManager;
import com.it_academy.pageobject.onliner.HomePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void navigateToHomePage() {
        HomePage homePage = new HomePage();
        homePage.navigate("https://www.onliner.by/");
        homePage.clickOnSectionLink("Каталог");
    }

    @AfterSuite
    public void closeBrowser() {
        DriverManager.closeBrowser();
    }

}
