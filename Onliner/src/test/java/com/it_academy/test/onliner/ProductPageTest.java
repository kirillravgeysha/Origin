package com.it_academy.test.onliner;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.it_academy.pageobject.onliner.HomePage;
import com.it_academy.pageobject.onliner.ProductPage;
import com.it_academy.test.BaseTest;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();

    @Test
    public void checkHeadPhonesParentProducts() {

        ElementsCollection parentProducts = homePage
                .clickOnCatalogLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickOnCatalogClassifierItem(" Аудиотехника ")
                .clickOnProductLink("Наушники")
                .getParentProducts();

        ElementsCollection parentProductsTitles = productPage
                .getParentProductsTitles();

        ElementsCollection parentProductsDescriptions = productPage
                .getParentProductsDescriptions();

        ElementsCollection parentProductsRatings = productPage
                .getParentProductsRatings();

        ElementsCollection parentProductsPrices = productPage
                .getParentProductsPrices();

        ElementsCollection parentProductsImages = productPage
                .getParentProductsImages();

        ElementsCollection parentProductsCheckboxes = productPage
                .getParentProductsCheckboxes();

        parentProductsTitles.shouldHave(CollectionCondition.size(parentProducts.size()));
        parentProductsDescriptions.shouldHave(CollectionCondition.size(parentProducts.size()));
        parentProductsRatings.shouldHave(CollectionCondition.size(parentProducts.size()));
        parentProductsPrices.shouldHave(CollectionCondition.size(parentProducts.size()));
        parentProductsImages.shouldHave(CollectionCondition.size(parentProducts.size()));
        parentProductsCheckboxes.shouldHave(CollectionCondition.size(parentProducts.size()));

    }

    @Test
    public void checkHeadPhonesChildProducts() {

        ElementsCollection childProducts = homePage
                .clickOnCatalogLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickOnCatalogClassifierItem(" Аудиотехника ")
                .clickOnProductLink("Наушники")
                .getChildProducts();

        ElementsCollection childProductsTitles = productPage
                .getChildProductsTitles();

        ElementsCollection childProductsPrices = productPage
                .getChildProductsPrices();

        ElementsCollection childProductsImages = productPage
                .gettChildProductsImages();

        ElementsCollection childProductsCheckboxes = productPage
                .gettChildProductsCheckboxes();

        childProductsTitles.shouldHave(CollectionCondition.size(childProducts.size()));
        childProductsTitles.shouldHave(CollectionCondition.size(childProducts.size()));
        childProductsPrices.shouldHave(CollectionCondition.size(childProducts.size()));
        childProductsImages.shouldHave(CollectionCondition.size(childProducts.size()));
        childProductsCheckboxes.shouldHave(CollectionCondition.size(childProducts.size()));

    }

}
