package ge.tbc.testautomation.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class DatabaseSteps {

    public Object[][] getAllUsers() {
        Object[][] allUsers;
        ResultSet resultSet;
        try (Connection connection = MSSQLConnection.connect()) {
            String SQL = "SELECT * FROM Registration.dbo.RegistrationData";

            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            resultSet = statement.executeQuery(SQL);

            resultSet.last();
            int rowCount = resultSet.getRow();
            resultSet.beforeFirst(); // Reset cursor to before first

            allUsers = new Object[rowCount][9];
            int index = 0;

            while (resultSet.next()) {
                allUsers[index][0] = resultSet.getString("firstName");
                allUsers[index][1] = resultSet.getString("lastName");
                allUsers[index][2] = resultSet.getString("gender");
                allUsers[index][3] = resultSet.getString("model");
                allUsers[index][4] = resultSet.getString("address1");
                allUsers[index][5] = resultSet.getString("address2");
                allUsers[index][6] = resultSet.getString("city");
                allUsers[index][7] = resultSet.getString("contact1");
                allUsers[index][8] = resultSet.getString("contact2");
                index++;
            }

            for (Object[] row : allUsers) {
                System.out.println(Arrays.toString(row));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allUsers;
    }
}
