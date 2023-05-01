package com.it_academy.test;

import com.it_academy.pageobject.onliner.HomePage;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void navigateToCatalogPage() {

        HomePage homePage = new HomePage();
        homePage.navigate("https://www.onliner.by/");
    }

}
