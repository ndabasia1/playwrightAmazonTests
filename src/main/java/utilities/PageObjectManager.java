package utilities;

import com.microsoft.playwright.Page;

import pages.HomePage;
import pages.SearchResultsPage;

/**
 * Allows all the page objects to be declared here
 */
public class PageObjectManager
{
    private Page page;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    /**
     * Allows the page to be set
     * <p>
     * @param page The page to set
     */
    public PageObjectManager(Page page)
    {
        this.page = page;
    }

    /**
     * Allow usage of the Home Page's methods
     */
    public HomePage getHomePage()
    {
        return (homePage == null) ? homePage = new HomePage(page) : homePage;
    }

    /**
     * Allow usage of the Search Results Page's methods
     */
    public SearchResultsPage getSearchResultsPage()
    {
        return (searchResultsPage == null) ? searchResultsPage = new SearchResultsPage(page) : searchResultsPage;
    }
}