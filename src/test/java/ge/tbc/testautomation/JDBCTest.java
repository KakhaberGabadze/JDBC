package ge.tbc.testautomation;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import ge.tbc.testautomation.data.DataSupplier;
import org.testng.annotations.Test;

public class JDBCTest extends JDBCBeforeAfter {

    @Test(dataProvider = "getData", dataProviderClass = DataSupplier.class)
    public void testName(String fName, String lName, String gender, String model, String address1,
                         String address2, String city, String contact1, String contact2) {

        techCanvassStep
                .fillData(fName, lName, gender, model, address1, address2, city, contact1, contact2)
                .clickRegisterButton();

//        Thread.sleep(2000);
        page.reload(new Page.ReloadOptions()
                .setTimeout(60000)
                .setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
//        Thread.sleep(2000);
    }
}
