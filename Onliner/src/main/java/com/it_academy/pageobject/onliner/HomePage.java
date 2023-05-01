package com.it_academy.pageobject.onliner;

import com.codeborne.selenide.SelenideElement;
import com.it_academy.pageobject.BasePage;
import org.openqa.selenium.support.ui.Quotes;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class HomePage extends BasePage {

    private static final String CATALOG_LINK_XPATH_PATTERN =
            "//span[@class='b-main-navigation__text' and text()='Каталог']";

    private final SelenideElement FAST_SEARCH_XPATH = $x("//form" +
            "[@class='fast-search__form']//input[@class='fast-search__input']");

    public CatalogPage clickOnCatalogLink(String link) {
        $x(format(CATALOG_LINK_XPATH_PATTERN, Quotes.escape(link))).shouldBe(visible, ofSeconds(30)).click();
        return new CatalogPage();
    }

    public IframeFastSearchPage setFastSearchValue(String string) {
        FAST_SEARCH_XPATH.shouldBe(visible, ofSeconds(30)).setValue(format(string));
        return new IframeFastSearchPage();
    }


}
