package com.it_academy.test.onliner;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.it_academy.pageobject.onliner.HomePage;
import com.it_academy.pageobject.onliner.IframeFastSearchPage;
import com.it_academy.test.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IframeFastSearchPageTest extends BaseTest {

    private HomePage homePage = new HomePage();

    private IframeFastSearchPage iframePage = new IframeFastSearchPage();


    @Test
    public void checkIframeFastSearchTabs() {

        ElementsCollection fastSearchResults = homePage
                .setFastSearchValue("Наушники")
                .switchToFrame()
                .selectIframeTabs();

        fastSearchResults.shouldHave(CollectionCondition.
                containExactTextsCaseSensitive("в каталоге", "в новостях", "на барахолке", "на форуме"));

    }

    @Test
    public void checkHeadPhonesIframeFastSearchCategory() {

        String regex = "\\d*"; /* description content pattern, where:
        \\d* - any number of digits,  eg : 8130 */

        ElementsCollection fastSearchCategoryResults = homePage
                .setFastSearchValue("Наушники")
                .switchToFrame()
                .getFastSearchCategoryResults();

        fastSearchCategoryResults.shouldHave(CollectionCondition.
                containExactTextsCaseSensitive("Наушники и гарнитуры"));

        ElementsCollection fastSearchCategoryResultsCount = iframePage
                .getFastSearchCategoryResultCount();

        List<String> categoryCounts = fastSearchCategoryResultsCount.texts();
        assertThat(categoryCounts.stream().
                allMatch(element -> element.matches(regex)))
                .as("Description is not contain number of products")
                .isTrue();

    }

    @Test
    public void checkIframeFastSearchTabNewsFilters() {

        ElementsCollection fastSearchTabFilters = homePage
                .setFastSearchValue("Наушники")
                .switchToFrame()
                .selectIframeTab("в новостях")
                .getIframeTabFilters();

        fastSearchTabFilters.shouldHave(CollectionCondition.
                containExactTextsCaseSensitive("В любом разделе", "За полгода", "Сначала релевантные"));

    }

    @Test
    public void checkCloseIframeFastSearchPage() {
        homePage
                .setFastSearchValue("Наушники")
                .switchToFrame()
                .closeIframePageByIcon();
        homePage.ExitFromFrame();
        iframePage.checkIframeNotVisible();

        homePage
                .setFastSearchValue("Наушники")
                .switchToFrame()
                .closeIframePageUsingOffset();
        homePage.ExitFromFrame();
        iframePage.checkIframeNotVisible();

        homePage
                .setFastSearchValue("Наушники")
                .switchToFrame()
                .closeIframePageUsingEscape();
        iframePage.checkIframeNotVisible();

    }


}
