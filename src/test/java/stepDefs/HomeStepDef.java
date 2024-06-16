package stepDefs;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import data.Constants.Label;
import data.Constants.Url;
import pages.HomePage;
import utilities.ScenarioContext;
import utilities.TestContext;

/**
 * Steps relating to the Home page are stored here
 */
public class HomeStepDef
{
    private HomePage homePage;
    private ScenarioContext scenarioContext;

    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Initialise page classes into objects
     * <p>
     * @param testContext Allows usage of TestContext methods to initialise the page
     */
    public HomeStepDef(TestContext testContext)
    {
        homePage = testContext.getPageObjectManager().getHomePage();
        scenarioContext = testContext.getScenarioContext();
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Navigate to the correct URL
     */
    @Given("^I have navigated to the correct URL$")
    public void navigateToUrl()
    {
        homePage.launchUrl(System.getProperty("url", Url.ENVIRONMENT));
        homePage.clickButton(Label.DECLINE);
        assertThat(homePage.getLogo()).isVisible();
    }

    /**
     * Click an icon in the navigation bar
     * <p>
     * @param iconName Icon to click
     */
    @When("^I click (.*) in the navigation bar$")
    public void clickNavigationIcon(String iconName)
    {
        homePage.clickNavigationIcon(iconName);
    }

    /**
     * Click a section name within the left side menu
     * <p>
     * @param sectionName The name of the section to click
     */
    @When("^I click (.*) in the menu canvas$")
    public void clickSection(String sectionName)
    {
        scenarioContext.setContext(ScenarioContext.Context.GENERAL.SECTION_NAME, sectionName);
        homePage.clickSection(sectionName);
    }

    /**
     * Click a sub-section name within the menu
     * <p>
     * @param subSectionName The name of the sub-section to click
     */
    @When("^I click (.*) in the submenu canvas$")
    public void clickSubSection(String subSectionName)
    {
        scenarioContext.setContext(ScenarioContext.Context.GENERAL.SECTION_NAME, subSectionName);
        homePage.clickSubSection(subSectionName);
    }
}