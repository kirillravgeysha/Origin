package com.it_academy.pageobject;

import com.it_academy.framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Supplier;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class BasePage {


    public BasePage() {
       DriverManager.initDriver("chrome");
    }

    public void navigate(String url) {
        getWebDriver().get(url);
    }

    public void ExitFromFrame() {
        getWebDriver().switchTo().defaultContent();
    }

}
