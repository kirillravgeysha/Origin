package com.it_academy.framework;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeDriverCreator implements WebDriverCreator<RemoteWebDriver> {

    @Override
    public ChromeDriver create() {

        return new ChromeDriver(new ChromeOptions().addArguments("disable-infobars",
                "disable-translate", "disable-notifications",
                "disable-popup-blocking", "ignore-certificate-errors"));
    }

}
