package stepDefs;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.microsoft.playwright.Locator;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import data.Constants.Label;
import pages.SearchResultsPage;
import utilities.PropertiesManager;
import utilities.ScenarioContext;
import utilities.TestContext;

/**
 * Steps relating to the Search Results page are stored here
 */
public class SearchResultsStepDef
{
    private SearchResultsPage searchResultsPage;
    private ScenarioContext scenarioContext;
    private PropertiesManager propertiesManager = PropertiesManager.getInstance();

    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Initialise page classes into objects
     * <p>
     * @param testContext Allows usage of TestContext methods to initialise the page
     */
    public SearchResultsStepDef(TestContext testContext)
    {
        searchResultsPage = testContext.getPageObjectManager().getSearchResultsPage();
        scenarioContext = testContext.getScenarioContext();
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Click a link within the banner
     * <p>
     * @param linkName The link to click within the banner
     */
    @When("^I click (.*) within the banner$")
    public void clickLinkInBanner(String linkName)
    {
        scenarioContext.setContext(ScenarioContext.Context.GENERAL.SECTION_NAME, linkName);
        searchResultsPage.clickLinkInBanner(linkName);
    }

    /**
     * Apply filters
     * <p>
     * @param filterField The field to apply a filter for
     * @param filterValue The filter to set
     */
    @When("^I set (.*) to (.*)$")
    public void setFilter(String filterField, String filterValue)
    {
        Map<String, String> filterNameValueMap = new HashMap<String, String>();
        filterNameValueMap.put(filterField, filterValue);
        scenarioContext.setContext(ScenarioContext.Context.GENERAL.FILTER_NAME_VALUE, filterNameValueMap);
        searchResultsPage.setFilter(filterField, filterValue);
    }

    /**
     * Slide the max price range to the far left
     */
    @When("^I slide the maximum price range to the far left$")
    public void slideMaxPriceRangeToFarLeft()
    {
        searchResultsPage.slideMaxPriceRangeToFarLeft();
        searchResultsPage.clickGo();
    }

    /**
     * Check you are taken to the correct search results screen
     */
    @Then("^I will be taken to the correct search results screen$")
    public void checkOnSearchResultsPage()
    {
        String sectionName = scenarioContext.getScenarioContextAsString(ScenarioContext.Context.GENERAL.SECTION_NAME);
        if (sectionName.contentEquals(Label.MOBILE_SMARTPHONES))
        {
            sectionName = sectionName.replace("Mobile Phones & ", "");
        }
        assertThat(searchResultsPage.getBanner()).containsText(sectionName);
    }

    /**
     * Check the filter is checked
     */
    @Then("^the filter will be checked$")
    public void checkFilterApplied()
    {
        Map<String, String> nameValue = scenarioContext.getScenarioContextAsStringMap(ScenarioContext.Context.GENERAL.FILTER_NAME_VALUE);
        for (Entry<String, String> entry : nameValue.entrySet())
        {
            assertThat(searchResultsPage.getCheckedFilter(entry.getKey(), entry.getValue())).isVisible();
        }
    }

    /**
     * List out all the Samsung phones into the cucumber report generated
     */
    @Then("^I will get all the Samsung phones with the above set of specifications$")
    public void listSamsungPhones()
    {
        Locator results = searchResultsPage.getResults();
        int resultsCount = results.count();
        Hooks.scenario.log("Mapping phones to Phones.txt file");
        for (int i = 0; i < resultsCount; ++i)
        {
            propertiesManager.createAndWriteToFile(results.nth(i).innerText());
        }
        propertiesManager.closeWriter();
    }
}