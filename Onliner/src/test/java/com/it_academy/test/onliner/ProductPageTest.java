package com.it_academy.test.onliner;

import com.it_academy.pageobject.onliner.CatalogPage;
import com.it_academy.pageobject.onliner.ProductPage;
import com.it_academy.test.BaseTest;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ProductPageTest extends BaseTest {
    CatalogPage catalogPage = new CatalogPage();
    ProductPage productPage = new ProductPage();

    @Test
    public void checkHeadPhonesParentProducts() {

        List<WebElement> parentProducts = catalogPage
                .clickOnSectionLink("Электроника")
                .clickOnCatalogClassifierLink(" Аудиотехника ")
                .clickOnProductLink("Наушники")
                .selectParentProducts();

        List<WebElement> parentProductsTitles = productPage
                .selectParentProductsTitle();

        List<WebElement> parentProductsDescriptions = productPage
                .selectParentProductsDescriptions();

        List<WebElement> parentProductsRatings = productPage
                .selectParentProductsRatings();

        List<WebElement> parentProductsPrices = productPage
                .selectParentProductsPrices();

        List<WebElement> parentProductsImages = productPage
                .selectParentProductsImages();

        List<WebElement> parentProductsCheckboxes = productPage
                .selectParentProductsCheckboxes();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(parentProducts.size())
                .as("Number of parent products are not match with number of titles")
                .isEqualTo(parentProductsTitles.size());
        softAssertions.assertThat(parentProducts.size())
                .as("Number of parent products are not match with number of descriptions")
                .isEqualTo(parentProductsDescriptions.size());
        softAssertions.assertThat(parentProducts.size())
                .as("Number of parent products are not match with number of ratings")
                .isEqualTo(parentProductsRatings.size());
        softAssertions.assertThat(parentProducts.size())
                .as("Number of parent products are not match with number of prices")
                .isEqualTo(parentProductsPrices.size());
        softAssertions.assertThat(parentProducts.size())
                .as("Number of parent products are not match with number of images")
                .isEqualTo(parentProductsImages.size());
        softAssertions.assertThat(parentProducts.size())
                .as("Number of parent products are not match with number of checkboxes")
                .isEqualTo(parentProductsCheckboxes.size());
    }

    @Test
    public void checkHeadPhonesChildProducts(){

        List<WebElement> childProducts = catalogPage
                .clickOnSectionLink("Электроника")
                .clickOnCatalogClassifierLink(" Аудиотехника ")
                .clickOnProductLink("Наушники")
                .selectChildProducts();

        List<WebElement> childProductsTitles = productPage
                .selectChildProductsTitle();

        List<WebElement> childProductsPrices = productPage
                .selectChildProductsPrices();

        List<WebElement> childProductsImages = productPage
                .selectChildProductsImages();

        List<WebElement> childProductsCheckboxes = productPage
                .selectChildProductsCheckboxes();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(childProducts.size())
                .as("Number of child products are not match with number of titles")
                .isEqualTo(childProductsTitles.size());
        softAssertions.assertThat(childProducts.size())
                .as("Number of child products are not match with number of prices")
                .isEqualTo(childProductsPrices.size());
        softAssertions.assertThat(childProducts.size())
                .as("Number of child products are not match with number of images")
                .isEqualTo(childProductsImages.size());
        softAssertions.assertThat(childProductsImages.size())
                .as("Number of child products are not match with number of checkboxes")
                .isEqualTo(childProductsCheckboxes.size());

    }

}
