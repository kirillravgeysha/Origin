package com.it_academy.pageobject.onliner;

import com.it_academy.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Quotes;

import static java.lang.String.format;

public class HomePage extends BasePage {

    private static final String CATALOG_LINK_XPATH_PATTERN =
            "//span[@class='b-main-navigation__text' and text()='Каталог']";

    public CatalogPage clickOnSectionLink(String link) {
        waitForElementVisible(By.xpath(format(CATALOG_LINK_XPATH_PATTERN, Quotes.escape(link))))
                .click();
        return new CatalogPage();
    }
}
