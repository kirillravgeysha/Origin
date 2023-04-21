package com.it_academy.pageobject.onliner;

import com.it_academy.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ProductPage extends BasePage {

    private static final String PARENT_PRODUCTS_XPATH =
            "//div[@class='schema-product__group']";

    private static final String CHILD_PRODUCTS_XPATH =
            "//div[@class='schema-product schema-product_children']";

    private static final String PARENT_PRODUCTS_TITLE_XPATH =
            "//div[@class='schema-product__title']//span[contains(@data-bind, 'product')]";

    private static final String CHILD_PRODUCTS_TITLE_XPATH =
            "//div[@class='schema-product__title']//span[contains(@data-bind, 'children')]";

    private static final String PARENT_PRODUCTS_DESCRIPTION_XPATH =
            "//div[@class='schema-products']//div[@class='schema-product__title']" +
                    "//span[@data-bind='html: product.extended_name || product.full_name']";

    private static final String PARENT_PRODUCTS_RATING_XPATH =
            "//div[@class='schema-products']//div[@class='schema-product__title']" +
                    "//span[@data-bind='html: product.extended_name || product.full_name']";

    private static final String PARENT_PRODUCTS_PRICE_XPATH =
            "//div[@class='schema-product__group']//div[contains(@data-bind, 'data: product')]" +
                    "//a[contains(@class, 'value_primary') or contains(@class, 'value_additional')]";

    private static final String CHILD_PRODUCTS_PRICE_XPATH =
            "//div[@class='schema-product schema-product_children']//div[contains(@data-bind, 'data: children')]" +
                    "//a[contains(@class, 'value_primary') or contains(@class, 'value_additional')]";

    private static final String PARENT_PRODUCTS_IMAGES_XPATH =
            "//div[@class='schema-product__group']//a[@class='js-product-image-link']" +
                    "/img[contains(@data-bind, 'alt: product')]";
    private static final String CHILD_PRODUCTS_IMAGES_XPATH =
            "//div[@class='schema-product__group']//a[@class='js-product-image-link']" +
                    "/img[contains(@data-bind, 'alt: children')]";

    private static final String PARENT_PRODUCTS_CHECKBOXES_XPATH =
            "//div[@class='schema-product__group']//div[@class='schema-product__compare']" +
                    "/div[contains(@data-bind, 'data: product')]";
    private static final String CHILD_PRODUCTS_CHECKBOXES_XPATH =
            "//div[@class='schema-product__group']//div[@class='schema-product__compare']" +
                    "/div[contains(@data-bind, 'data: children')]";

    public List<WebElement> selectParentProducts() {
        return waitForExpectedElements(By.xpath(PARENT_PRODUCTS_XPATH));
    }

    public List<WebElement> selectChildProducts() {
        return waitForExpectedElements(By.xpath(CHILD_PRODUCTS_XPATH));
    }

    public List<WebElement> selectParentProductsTitle() {
        return waitForExpectedElements(By.xpath(PARENT_PRODUCTS_TITLE_XPATH));
    }

    public List<WebElement> selectChildProductsTitle() {
        return waitForExpectedElements(By.xpath(CHILD_PRODUCTS_TITLE_XPATH));
    }

    public List<WebElement> selectParentProductsDescriptions() {
        return waitForExpectedElements(By.xpath(PARENT_PRODUCTS_DESCRIPTION_XPATH));
    }

    public List<WebElement> selectParentProductsRatings() {
        return waitForExpectedElements(By.xpath(PARENT_PRODUCTS_RATING_XPATH));
    }

    public List<WebElement> selectParentProductsPrices() {
        return waitForExpectedElements(By.xpath(PARENT_PRODUCTS_PRICE_XPATH));
    }

    public List<WebElement> selectChildProductsPrices() {
        return waitForExpectedElements(By.xpath(CHILD_PRODUCTS_PRICE_XPATH));
    }

    public List<WebElement> selectParentProductsImages() {
        return waitForExpectedElements(By.xpath(PARENT_PRODUCTS_IMAGES_XPATH));
    }

    public List<WebElement> selectChildProductsImages() {
        return waitForExpectedElements(By.xpath(CHILD_PRODUCTS_IMAGES_XPATH));
    }

    public List<WebElement> selectParentProductsCheckboxes() {
        return waitForExpectedElements(By.xpath(PARENT_PRODUCTS_CHECKBOXES_XPATH));
    }

    public List<WebElement> selectChildProductsCheckboxes() {
        return waitForExpectedElements(By.xpath(CHILD_PRODUCTS_CHECKBOXES_XPATH));
    }

}
