package com.it_academy.pageobject.onliner;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.pageobject.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;


public class CatalogPage extends BasePage {

    private final ElementsCollection CATALOG_CLASSIFIER_LINKS_XPATH
            = $$x("//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text())]");

    private final SelenideElement CATALOG_CLASSIFIER_XPATH = $x("//div[@class='catalog-navigation-list " +
            " catalog-navigation-list_active catalog-navigation-list_opened']");

    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//span[@class='catalog-navigation-classifier__item-title-wrapper' and contains(text(), '%s')]";

    private final ElementsCollection CATALOG_CLASSIFIERS_XPATH = $$x("//div" +
            "[@class='catalog-navigation-list__aside-list']/div/div[@class='catalog-navigation-list__aside-title']");

    private static final String CATALOG_CLASSIFIER_ITEM_XPATH_PATTERN =
            "//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title') and text() = '%s']";

    private final ElementsCollection CATALOG_PRODUCTS_XPATH = $$x("//div[contains" +
            "(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]");


    private final ElementsCollection CATALOG_PRODUCTS_TITLE_XPATH = $$x("//div[contains" +
            "(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]" +
            "/a[contains(@href, 'onliner')]//span[contains(@class, 'title')]");

    private final ElementsCollection CATALOG_PRODUCTS_DESCRIPTION_XPATH = $$x("//div[contains" +
            "(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]" +
            "/a[contains(@href, 'onliner')]//span[contains(@class, 'description')]");

    private static final String CATALOG_PRODUCT_XPATH_PATTERN =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]"
                    + "/a[contains(@href, 'onliner')]//span[contains(@class, 'title') and contains(text(), '%s')]";

    public ElementsCollection getCatalogClassifierLinks() {
        return CATALOG_CLASSIFIER_LINKS_XPATH.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public void isCatalogClassifierDisplayed() {
        CATALOG_CLASSIFIER_XPATH.shouldBe(visible, ofSeconds(30));
    }

    public CatalogPage clickOnCatalogClassifierLink(String link) {
        $x(format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link)).shouldBe(visible, ofSeconds(30)).click();
        return this;
    }

    public CatalogPage clickOnCatalogClassifierItem(String link) {
        $x(format(CATALOG_CLASSIFIER_ITEM_XPATH_PATTERN, link)).shouldBe(visible, ofSeconds(30)).click();
        return this;
    }

    public ElementsCollection getCatalogClassifiers() {
        return CATALOG_CLASSIFIERS_XPATH.shouldBe(CollectionCondition.anyMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));

    }

    public ElementsCollection getCatalogProducts() {
        return CATALOG_PRODUCTS_XPATH.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection getCatalogProductsTitle() {
        return CATALOG_PRODUCTS_TITLE_XPATH.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection getCatalogProductsDescription() {
        return CATALOG_PRODUCTS_DESCRIPTION_XPATH.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ProductPage clickOnProductLink(String product) {
        $x(format(CATALOG_PRODUCT_XPATH_PATTERN, product)).shouldBe(visible, ofSeconds(30)).click();
        return new ProductPage();
    }

}
