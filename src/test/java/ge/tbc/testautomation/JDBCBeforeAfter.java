package ge.tbc.testautomation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import ge.tbc.testautomation.Steps.TechCanvassStep;
import ge.tbc.testautomation.data.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;

public class JDBCBeforeAfter {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    TechCanvassStep techCanvassStep;


    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setArgs(Arrays.asList("--disable-extensions"));
        launchOptions.setHeadless(false);
//        launchOptions.setSlowMo(1000);
        browser = playwright.chromium().launch(launchOptions);
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080));
        page = browserContext.newPage();
        page.navigate(Constants.TECHCANVASS_URL,
                new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
        techCanvassStep = new TechCanvassStep(page);
    }

    @AfterClass
    public void tearDown() {
        browserContext.close();
        browser.close();
        playwright.close();
    }
}
