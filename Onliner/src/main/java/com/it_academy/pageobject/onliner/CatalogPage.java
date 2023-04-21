package com.it_academy.pageobject.onliner;

import com.it_academy.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;

public class CatalogPage extends BasePage {

    private static final String ELEMENTS_XPATH =
            "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text())]";


    private static final String CLASSIFIER_XPATH =
            "//div[@class='catalog-navigation-list  catalog-navigation-list_active catalog-navigation-list_opened']";

    private static final String SECTION_XPATH_PATTERN =
            "//span[@class='catalog-navigation-classifier__item-title-wrapper' and contains(text(), '%s')]";


    private static final String CLASSIFIERS_XPATH =
            "//div[@class='catalog-navigation-list__aside-list']/div/div[@class='catalog-navigation-list__aside-title']";

    private static final String CLASSIFIER_XPATH_PATTERN =
            "//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title') and text() = '%s']";

    private static final String PRODUCTS_XPATH =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]" +
                    "/a[contains(@href, 'onliner')]";

    private static final String PRODUCTS_TITLE_XPATH =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]" +
                    "/a[contains(@href, 'onliner')]//span[contains(@class, 'title')]";

    private static final String PRODUCTS_DESCRIPTION_XPATH =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]" +
                    "/a[contains(@href, 'onliner')]//span[contains(@class, 'description')]";

    private static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]"
                    + "/a[contains(@href, 'onliner')]//span[contains(@class, 'title') and contains(text(), '%s')]";

    public List<WebElement> selectCatalogElements() {
        return waitForExpectedElements(By.xpath(ELEMENTS_XPATH));
    }

    public boolean isCatalogClassifierIsDisplayed() {
        return isElementDisplayed(By.xpath(CLASSIFIER_XPATH));
    }

    public CatalogPage clickOnSectionLink(String link) {
        waitForElementVisible(By.xpath(format(SECTION_XPATH_PATTERN, link))).click();
        return this;
    }

    public List<WebElement> selectCatalogClassifiers() {
        return waitForExpectedElements(By.xpath(CLASSIFIERS_XPATH));
    }

    public CatalogPage clickOnCatalogClassifierLink(String link) {
        waitForElementVisible(By.xpath(format(CLASSIFIER_XPATH_PATTERN, link)))
                .click();
        return this;
    }

    public List<WebElement> selectCatalogProducts() {
        return waitForExpectedElements(By.xpath(PRODUCTS_XPATH));
    }

    public List<WebElement> selectCatalogProductsTitle() {
        return waitForExpectedElements(By.xpath(PRODUCTS_TITLE_XPATH));
    }

    public List<WebElement> selectCatalogProductsDescription() {
        return waitForExpectedElements(By.xpath(PRODUCTS_DESCRIPTION_XPATH));
    }

    public ProductPage clickOnProductLink(String product) {
        waitForElementVisible(By.xpath(format(PRODUCT_XPATH_PATTERN, product)))
                .click();
        return new ProductPage();
    }

}
