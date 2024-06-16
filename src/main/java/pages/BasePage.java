package pages;

import java.util.logging.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;

/**
 * This page contains methods and locators relating to all pages on Amazon
 */
public class BasePage
{
    protected Page page;
    protected static final Logger LOGGER = Logger.getLogger(BasePage.class.getName());

    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Pass the page through to allow Playwright's methods to be used
     * <p>
     * @param page The page to interact with
     */
    public BasePage(Page page)
    {
        this.page = page;
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Get the logo element
     * <p>
     * @return the logo element
     */
    public Locator getLogo()
    {
        return page.locator("#nav-logo a[aria-label='Amazon.co.uk']");
    }

    /**
     * Navigate to the correct URL
     */
    public void launchUrl(String url)
    {
        page.navigate(url);
    }

    /**
     * Click a button
     * <p>
     * @param buttonName The name of the button to click
     */
    public void clickButton(String buttonName)
    {
        try
        {
            page.locator("//button[text()='" + buttonName + "']").click();
        }
        catch (TimeoutError e)
        {
            LOGGER.info("Button not found, continuing with the test");
        }
    }

    /**
     * Click an icon in the navigation bar
     * <p>
     * @param iconName Icon to click
     */
    public void clickNavigationIcon(String iconName)
    {
        page.locator("#nav-main").locator("//span[text()='" + iconName + "']").click();
    }

    /**
     * Click a section name within the left side menu
     * <p>
     * @param sectionName The name of the section to click
     */
    public void clickSection(String sectionName)
    {
        page.locator("#hmenu-canvas").locator("//div[text()='" + sectionName + "']").nth(0).click();
    }

    /**
     * Click a sub-section name within the left side menu
     * <p>
     * @param subsectionName The name of the sub-section to click
     */
    public void clickSubSection(String subsectionName)
    {
        page.locator("#hmenu-canvas").locator("//a[text()='" + subsectionName + "']").nth(0).dispatchEvent("click");
    }
}