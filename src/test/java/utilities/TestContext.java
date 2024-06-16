package utilities;

/**
 * Allows parameters to be declared once throughout a test cycle
 */
public class TestContext
{
    private BrowserUtilities browserUtilities;
    private PageObjectManager pageObjectManager;
    private ScenarioContext scenarioContext;

    /**
     * Creates objects that will be created when Test Context is used
     */
    public TestContext()
    {
        browserUtilities = new BrowserUtilities();
        pageObjectManager = new PageObjectManager(browserUtilities.getPage());
        scenarioContext = new ScenarioContext();
    }

    /**
     * Allows the usage of BrowserUtilities methods through test context
     * <p>
     * @return the browserUtilities object
     */
    public BrowserUtilities getBrowserUtilities()
    {
        return browserUtilities;
    }

    /**
     * Allows the usage of page methods through the PageObjectManager
     * <p>
     * @return the pageObjectManager object
     */
    public PageObjectManager getPageObjectManager()
    {
        return pageObjectManager;
    }

    /**
     * Allows the usage of scenario context methods
     * <p>
     * @return the scenarioContext object
     */
    public ScenarioContext getScenarioContext()
    {
        return scenarioContext;
    }
}