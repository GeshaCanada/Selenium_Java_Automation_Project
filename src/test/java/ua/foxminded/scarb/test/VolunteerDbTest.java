package ua.foxminded.scarb.test;

import org.testng.annotations.Test;
import ua.foxminded.scarb.helpers.DatabaseSingleton;
import utils.RandomStringGenerator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VolunteerDbTest {

    @Test
    public void insertVolunteerTest() {
        // Get the singleton instance of the database connection
        DatabaseSingleton databaseSingleton = DatabaseSingleton.getInstance();

        String randomEmail = RandomStringGenerator.generateRandomEmail();
        try {
            insertVolunteer(databaseSingleton.getConnection(),
                    "F*CK_PTN", "PLANKTON", "Gg23021981Gg!", "M", randomEmail, "ROLE_VOLUNTEER",
                    "active", "2023-11-23 02:20:25", "2023-11-23 05:20:28", "CA", false, false);

            boolean recordExists = databaseSingleton.doesRecordExist("SELECT * FROM users WHERE email = ?", randomEmail);

            if (recordExists) {
                System.out.println("Volunteer inserted successfully!");
            } else {
                System.out.println("Failed to insert volunteer or record does not exist.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection (make sure to do this when you're done)
            databaseSingleton.closeConnection();
        }
    }

    private static void insertVolunteer(Connection connection, String first_name, String last_name, String password,
                                        String sex, String email, String role, String status, String created_date, String updated_date, String locale, Boolean email_confirmed, Boolean owner)
            throws SQLException {
        String insertQuery = "INSERT INTO users (first_name, last_name, password, sex, email, role, status, created_date, updated_date, locale, email_confirmed, owner ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, sex);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, role);
            preparedStatement.setString(7, status);
            preparedStatement.setString(8, created_date);
            preparedStatement.setString(9, updated_date);
            preparedStatement.setString(10, locale);
            preparedStatement.setBoolean(11, email_confirmed);
            preparedStatement.setBoolean(12, owner);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Ok!");
            } else {
                System.out.println("Fail");
            }
        }
    }
}
