package ge.tbc.testautomation.Steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.Pages.TechCanvassPage;

public class TechCanvassStep {
    Page page;
    TechCanvassPage techCanvassPage;

    public TechCanvassStep(Page page) {
        this.page = page;
        this.techCanvassPage = new TechCanvassPage(page);
    }

    public TechCanvassStep fillData(String fName, String lName, String gender, String model, String address1,
                                    String address2, String city, String contact1, String contact2) {
        techCanvassPage.firstName.fill(fName);
        techCanvassPage.lastName.fill(lName);
        techCanvassPage.gend(page, gender).check();
        techCanvassPage.mod.selectOption(model);
        techCanvassPage.addr1.fill(address1);
        techCanvassPage.addr2.fill(address2);
        techCanvassPage.cit.fill(city);
        techCanvassPage.cont1.fill(contact1);
        techCanvassPage.cont2.fill(contact2);

        return this;
    }

    public TechCanvassStep clickRegisterButton() {
        techCanvassPage.registerButton.click();

        return this;
    }
}
