package com.it_academy.test.onliner;

import com.it_academy.pageobject.onliner.CatalogPage;
import com.it_academy.test.BaseTest;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CatalogPageTest extends BaseTest {

    private CatalogPage catalogPage = new CatalogPage();

    @Test
    public void checkCatalogSections() {

        List<String> expectedSections = Arrays.asList("Электроника", "Компьютеры и сети", "Бытовая техника", "На каждый день",
                "Стройка и ремонт", "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам");

        List<WebElement> sections = catalogPage.selectCatalogElements();
        List<String> actualSections = sections.stream()
                .skip(1)
                .map(element -> element.getText())
                .collect(Collectors.toList());

        assertThat(actualSections)
                .as("Sections are not match")
                .isEqualTo(expectedSections);
    }

    @Test
    public void checkCatalogClassifierIsExist() {
        catalogPage.clickOnSectionLink("Компьютеры");
        assertThat(new CatalogPage().isCatalogClassifierIsDisplayed())
                .as("Dropdown section is not displayed")
                .isTrue();
    }

    @Test
    public void checkNotebookComputerMonitorAndAccessoriesClassifiers() {

        List<String> expectedClassifiers = Arrays.asList("Ноутбуки, компьютеры, мониторы", "Комплектующие");
        List<WebElement> classifiers = catalogPage
                .clickOnSectionLink("Компьютеры")
                .selectCatalogClassifiers();
        List<String> actualClassifiers = classifiers.stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
        actualClassifiers.forEach(System.out::println);
        assertThat(actualClassifiers.containsAll(expectedClassifiers))
                .as("NotebookComputerMonitor and Accessories classifiers are not match")
                .isTrue();
    }

    @Test
    public void checkAccessoriesProducts() {

        List<WebElement> products = catalogPage
                .clickOnSectionLink("Компьютеры")
                .clickOnCatalogClassifierLink(" Комплектующие ")
                .selectCatalogProducts();

        List<WebElement> productsTitle = catalogPage
                .selectCatalogProductsTitle();

        List<WebElement> productsDescription = catalogPage
                .selectCatalogProductsDescription();

        List<String> productsDescriptionContent = productsDescription.stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(products.size())
                .as("Number of products are not match with number of titles")
                .isEqualTo(productsTitle.size());
        softAssertions.assertThat(products.size())
                .as("Number of products are not match with number of descriptions")
                .isEqualTo(productsDescription.size());
        assertThat(productsDescriptionContent.stream().
                allMatch(element -> element.matches("\\S*\\sтовар\\S*\\nот\\s\\S*\\sр.")))
                .as("Description is not contain number of products or minimum price")
                .isTrue();
    }

}
