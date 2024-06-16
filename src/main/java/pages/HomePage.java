package pages;

import com.microsoft.playwright.Page;

/**
 * This page contains methods and locators relating to the Home Page
 */
public class HomePage extends BasePage
{
    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Use the constructor set within Base Page
     * <p>
     * @param page The page to interact with
     */
    public HomePage(Page page)
    {
        super(page);
    }
}