package com.it_academy.test.steps;

import com.it_academy.navigation.OnlinerNavigation;
import com.it_academy.pageobject.onliner.HomePage;
import com.it_academy.pageobject.onliner.FastSearchFrame;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartSteps {

    HomePage homePage = new HomePage();

    FastSearchFrame iframeFastSearchPage = new FastSearchFrame();

    @Given("the user opens Onliner website")
    public void userOpensOnlinerWebsite() {
        OnlinerNavigation.navigateToPortalPage();
    }

    @When("the user set {string} in search menu")
    public void userSetProductCategoryInSearchMenu(String productCategory) {
        homePage.setFastSearchValue(productCategory)
                .switchToFrame();
    }

    @When("the user clicks on the {string} offer button")
    public void userClicksOnTheProductOfferButton(String productName) {
        iframeFastSearchPage.clickOnProductOffer(productName);
    }

    @When("the user clicks on the AddToCart button")
    public void userClicksOnTheAddToCartButton() {
        iframeFastSearchPage.clickOnAddToCartButton();
    }
    @When("the user clicks on the Cart button")
    public void userClicksOnTheCartButton() {
        iframeFastSearchPage.clickOnCartButton();
    }

    @Then("product with title {string} is displayed")
    public void verifyProductTitleIsDisplayed(String productTitle) {
        iframeFastSearchPage.checkProductWasAddedToCart(productTitle);

    }
}
