package com.it_academy.pageobject.onliner;

import com.codeborne.selenide.*;
import com.it_academy.pageobject.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class IframeFastSearchPage extends BasePage {

    private final SelenideElement IFRAME_XPATH = $x("//iframe[@class='modal-iframe']");
    private final SelenideElement IFRAME_ACTIVE_XPATH = $x("//body");

    private final ElementsCollection FAST_SEARCH_CATEGORY_RESULTS_XPATH = $$x("//div" +
            "[@class='result__item result__item_category']/a");

    private final ElementsCollection FAST_SEARCH_CATEGORY_RESULTS_COUNT_XPATH = $$x("//div" +
            "[@class='result__item result__item_category']//span[@data-bind='text: $data.products_count']");

    private final String IFRAME_TABS_XPATH =
            "//div[@class='search__tabs-list']/div";

    private static final String IFRAME_TAB_XPATH_PATTERN =
            "//div[@class='search__tabs-list']/div[contains(text(), '%s')]";

    private final ElementsCollection IFRAME_FILTER_LIST_XPATH = $$x("//div" +
            "[@class='search__filter-list']//a[normalize-space(text())]");

    private final SelenideElement IFRAME_CLOSE_ICON_XPATH = $x("//span[@class='search__close']");

    public ElementsCollection getFastSearchCategoryResults() {
        return FAST_SEARCH_CATEGORY_RESULTS_XPATH.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection getFastSearchCategoryResultCount() {
        return FAST_SEARCH_CATEGORY_RESULTS_COUNT_XPATH.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public ElementsCollection selectIframeTabs() {
        return $$x(IFRAME_TABS_XPATH).shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public IframeFastSearchPage selectIframeTab(String string) {
        $x(format(IFRAME_TAB_XPATH_PATTERN, string)).shouldBe(visible, ofSeconds(30)).click();
        return new IframeFastSearchPage();
    }

    public ElementsCollection getIframeTabFilters() {
        return IFRAME_FILTER_LIST_XPATH.shouldBe(CollectionCondition.allMatch
                ("Element is not displayed", el -> el.isDisplayed()), ofSeconds(30));
    }

    public IframeFastSearchPage switchToFrame() {
        getWebDriver().switchTo().frame(IFRAME_XPATH);
        return this;
    }

    public void closeIframePageByIcon() {
        IFRAME_CLOSE_ICON_XPATH.shouldBe(visible, ofSeconds(30)).click();
    }

    public void closeIframePageUsingOffset() {
        IFRAME_ACTIVE_XPATH.shouldBe(visible, ofSeconds(30)).click(ClickOptions.withOffset(-800, 0));
    }

    public void closeIframePageUsingEscape() {
        IFRAME_ACTIVE_XPATH.pressEscape();
    }

    public void checkIframeNotVisible() {
        IFRAME_XPATH.shouldNotBe(visible, ofSeconds(30));
    }


}
