package ge.tbc.testautomation.data;

import org.testng.annotations.DataProvider;

public class DataSupplier {
    DatabaseSteps databaseSteps = new DatabaseSteps();

    @DataProvider
    public Object[][] getData() {
        return databaseSteps.getAllUsers();
    }
}
