package utilities;

import java.io.File;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import data.Constants.BrowserName;

/**
 * Sets up the browser
 */
public class BrowserUtilities
{
    private Page page;

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Gets the browser's page
     * <p>
     * @return a page
     */
    public Page getPage()
    {
        if (page == null)
        {
            createBrowserPage(BrowserName.CHROMIUM);
        }
        return page;
    }

    /**
     * Close the browser
     */
    public void cleanUp()
    {
        page.close();
    }

    /* **************** 
     *  PRIVATE METHODS 
     ****************** */

    /**
     * Create the browser page to use
     * <p>
     * @param browserName Name of the browser to use
     */
    private void createBrowserPage(String browserName)
    {
        BrowserType browserType = null;
        Playwright playwright = Playwright.create();
        if (browserName.contentEquals(BrowserName.CHROMIUM))
        {
            browserType = playwright.chromium();
        }
        else
        {
            browserType = playwright.webkit();
        }
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(Boolean.valueOf(System.getProperty("headless", "true"))));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1525, 750).setRecordVideoDir(Paths.get(System.getProperty("user.dir") + File.separator + "target/cucumber-reports")).setRecordVideoSize(1525, 750));
        this.page = context.newPage();
    }
}