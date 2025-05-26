package ge.tbc.testautomation.Pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TechCanvassPage {
    public TechCanvassPage(Page page) {
        this.firstName = page.locator("//input[@value='First Name']");
        this.lastName = page.locator("//input[@value='Last Name']");
        this.mod = page.locator("//select[@name='model']");
        this.addr1 = page.locator("//input[@value='Address1']");
        this.addr2 = page.locator("//input[@value='Address2']");
        this.cit = page.locator("//input[@value='City']");
        this.cont1 = page.locator("//input[@value='Contact1']");
        this.cont2 = page.locator("//input[@value='Contact2']");
        this.registerButton = page.locator("//input[@value='Register']");
    }

    public Locator firstName,
            lastName,
            mod,
            addr1,
            addr2,
            cit,
            cont1,
            cont2,
            registerButton;

    public Locator gend(Page page, String gender) {
        return page.locator("//input[@value='" + gender + "']");
    }

}
