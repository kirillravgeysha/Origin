package com.it_academy.pageobject.onliner;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.it_academy.pageobject.BasePage;

import static com.codeborne.selenide.Selenide.$$x;
import static java.time.Duration.ofSeconds;


public class ProductPage extends BasePage {

    private final ElementsCollection PARENT_PRODUCTS_XPATH = $$x("//div[@class='schema-product']");

    private final ElementsCollection CHILD_PRODUCTS_XPATH = $$x("//div" +
            "[@class='schema-product schema-product_children']");

    private final ElementsCollection PARENT_PRODUCTS_TITLE_XPATH = $$x("//div" +
            "[@class='schema-product__title']//span[contains(@data-bind, 'product')]");

    private final ElementsCollection CHILD_PRODUCTS_TITLE_XPATH = $$x("//div" +
            "[@class='schema-product__title']//span[contains(@data-bind, 'children')]");

    private final ElementsCollection PARENT_PRODUCTS_DESCRIPTION_XPATH = $$x("//div" +
            "[@class='schema-products']//div[@class='schema-product__title']//span" +
            "[@data-bind='html: product.extended_name || product.full_name']");

    private final ElementsCollection PARENT_PRODUCTS_RATING_XPATH = $$x("//div" +
            "[@class='schema-products']//div[@class='schema-product__title']//span" +
            "[@data-bind='html: product.extended_name || product.full_name']");

    private final ElementsCollection PARENT_PRODUCTS_PRICE_XPATH = $$x("//div" +
            "[@class='schema-product__group']//div[contains(@data-bind, 'data: product')]//a" +
            "[contains(@class, 'value_primary') or contains(@class, 'value_additional')]");

    private final ElementsCollection CHILD_PRODUCTS_PRICE_XPATH = $$x("//div" +
            "[@class='schema-product schema-product_children']//div[contains(@data-bind, 'data: children')]//a" +
            "[contains(@class, 'value_primary') or contains(@class, 'value_additional')]");

    private final ElementsCollection PARENT_PRODUCTS_IMAGES_XPATH = $$x("//div" +
            "[@class='schema-product__group']//a[@class='js-product-image-link']/img" +
            "[contains(@data-bind, 'alt: product')]");

    private final ElementsCollection CHILD_PRODUCTS_IMAGES_XPATH = $$x("//div" +
            "[@class='schema-product__group']//a[@class='js-product-image-link']/img" +
            "[contains(@data-bind, 'alt: children')]");

    private final ElementsCollection PARENT_PRODUCTS_CHECKBOXES_XPATH = $$x("//div" +
            "[@class='schema-product__group']//div[@class='schema-product__compare']/div" +
            "[contains(@data-bind, 'data: product')]");

    private final ElementsCollection CHILD_PRODUCTS_CHECKBOXES_XPATH = $$x("//div" +
            "[@class='schema-product__group']//div[@class='schema-product__compare']/div" +
            "[contains(@data-bind, 'data: children')]");

    public ElementsCollection getParentProducts() {
        return PARENT_PRODUCTS_XPATH.shouldHave(CollectionCondition.allMatch("", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection getChildProducts() {
        return CHILD_PRODUCTS_XPATH.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));

    }

    public ElementsCollection getParentProductsTitles() {
        return PARENT_PRODUCTS_TITLE_XPATH.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection getChildProductsTitles() {
        return CHILD_PRODUCTS_TITLE_XPATH.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection getParentProductsDescriptions() {
        return PARENT_PRODUCTS_DESCRIPTION_XPATH.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection getParentProductsRatings() {
        return PARENT_PRODUCTS_RATING_XPATH.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection getParentProductsPrices() {
        return PARENT_PRODUCTS_PRICE_XPATH.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection getChildProductsPrices() {
        return CHILD_PRODUCTS_PRICE_XPATH.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection getParentProductsImages() {
        return PARENT_PRODUCTS_IMAGES_XPATH.shouldBe(
                CollectionCondition.anyMatch("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection gettChildProductsImages() {
        return CHILD_PRODUCTS_IMAGES_XPATH.shouldBe(
                CollectionCondition.anyMatch("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection getParentProductsCheckboxes() {
        return PARENT_PRODUCTS_CHECKBOXES_XPATH.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection gettChildProductsCheckboxes() {
        return CHILD_PRODUCTS_CHECKBOXES_XPATH.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }


}
