package com.it_academy.test.onliner;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.it_academy.pageobject.onliner.CatalogPage;
import com.it_academy.pageobject.onliner.HomePage;
import com.it_academy.test.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CatalogPageTest extends BaseTest {

    HomePage homePage = new HomePage();

    private CatalogPage catalogPage = new CatalogPage();

    @Test
    public void checkCatalogClassifierLinks() {

        ElementsCollection sections = homePage
                .clickOnCatalogLink("Каталог")
                .getCatalogClassifierLinks();
        sections.shouldHave(CollectionCondition.containExactTextsCaseSensitive
                ("Электроника", "Компьютеры и сети", "Бытовая техника", "На каждый день",
                        "Стройка и ремонт", "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам"));

    }

    @Test
    public void checkCatalogClassifierIsExist() {
        homePage
                .clickOnCatalogLink("Каталог")
                .clickOnCatalogClassifierLink("Компьютеры")
                .isCatalogClassifierDisplayed();

    }

    @Test
    public void checkNotebookComputerMonitorAndAccessoriesClassifiers() {

        ElementsCollection classifiers = homePage
                .clickOnCatalogLink("Каталог")
                .clickOnCatalogClassifierLink("Компьютеры")
                .getCatalogClassifiers();

        classifiers.shouldHave(CollectionCondition.
                containExactTextsCaseSensitive("Ноутбуки, компьютеры, мониторы", "Комплектующие"));

    }

    @Test
    public void checkAccessoriesProducts() {

        String regex = "\\S*\\sтовар\\S*\\nот\\s\\S*\\sр."; /* description content pattern, where:
         \\S* - any number of characters, \\s - space,  \\n - transition to a new line
         товар - exact text, от - exact text, р. - exact text
         eg :  1,509 товаров
               от 75,51 р.*/

        ElementsCollection products = homePage
                .clickOnCatalogLink("Каталог")
                .clickOnCatalogClassifierLink("Компьютеры")
                .clickOnCatalogClassifierItem(" Комплектующие ")
                .getCatalogProducts();

        ElementsCollection productsTitle = catalogPage
                .getCatalogProductsTitle();

        ElementsCollection productsDescription = catalogPage
                .getCatalogProductsDescription();

        productsTitle.shouldHave(CollectionCondition.size(products.size()));
        productsDescription.shouldHave(CollectionCondition.size(products.size()));

        List<String> productsDescriptionContent = productsDescription.texts();
        assertThat(productsDescriptionContent.stream().
                allMatch(element -> element.matches(regex)))
                .as("Description is not contain number of products or minimum price")
                .isTrue();

    }

}
