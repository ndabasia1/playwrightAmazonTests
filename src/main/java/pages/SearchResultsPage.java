package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * This page contains methods and locators relating to the Search Results Page
 */
public class SearchResultsPage extends BasePage
{
    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Use the constructor set within Base Page
     * <p>
     * @param page The page to interact with
     */
    public SearchResultsPage(Page page)
    {
        super(page);
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Get the banner element
     * <p>
     * @return the banner element
     */
    public Locator getBanner()
    {
        return page.locator(".pageBanner");
    }

    /**
     * Get the filter element
     * <p>
     * @param filterField The field to look for the filter value within
     * @return the filter element
     */
    public Locator getFilterField(String filterField)
    {
        return page.locator("#s-refinements").locator("//span[text()='" + filterField + "']/../..");
    }

    /**
     * Get the checked filter element
     * <p>
     * @param filterField The field that contains the field Value
     * @param filterValue The value to get the checkbox for
     * @return the checked filter element
     */
    public Locator getCheckedFilter(String filterField, String filterValue)
    {
        return getFilterField(filterField).locator("//span[text()='" + filterValue + "']").locator("..").locator("input[checked]");
    }

    /**
     * Get the search results
     * <p>
     * @return the search results element
     */
    public Locator getResults()
    {
        return page.locator("div[data-component-type='s-search-result'] div[data-cy='title-recipe']");
    }

    /**
     * Click a link within the banner
     * <p>
     * @param linkName The link to click within the banner
     */
    public void clickLinkInBanner(String linkName)
    {
        getBanner().locator("//a[text()='" + linkName + "']").click();
    }

    /**
     * Apply filters
     * <p>
     * @param filterField The field to apply a filter for
     * @param filterValue The filter to set
     */
    public void setFilter(String filterField, String filterValue)
    {
        getFilterField(filterField).hover();
        Locator list = getFilterField(filterField).locator("li .a-size-base");
        for (int i = 0; i < list.count(); ++i)
        {
            if (list.nth(i).textContent().contains(filterValue))
            {
                list.nth(i).click();
                break;
            }
        }
    }

    /**
     * Slide the max price range to the far left.
     */
    public void slideMaxPriceRangeToFarLeft()
    {
        page.locator(".s-upper-bound").click(new Locator.ClickOptions().setForce(true));
        Locator maximum = page.locator("label[aria-label='Maximum']");
        int counter = 0;
        while (!maximum.innerText().contentEquals("£100") && counter < 100)
        {
            page.locator("input[id='p_36/range-slider_slider-item_upper-bound-slider']").press("ArrowLeft");
            counter++;
        }
    }

    /**
     * Click the Go button for the price range
     */
    public void clickGo()
    {
        page.locator("input[aria-label='Submit price range']").click();
    }
}