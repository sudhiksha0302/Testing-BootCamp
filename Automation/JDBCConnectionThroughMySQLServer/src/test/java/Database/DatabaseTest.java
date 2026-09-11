package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DatabaseTest {

    @Test
    public void testDatabaseConnection() throws SQLException, ClassNotFoundException {

        // Database details
        String dbURL = "jdbc:mysql://localhost:3306/SeleniumAutomation";
        String username = "root";
        String password = "Sudhiksha@2006";

        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection
        Connection con = DriverManager.getConnection(dbURL, username, password);

        System.out.println("Database connection successful");

        // Create Statement
        Statement stmt = con.createStatement();

        // SQL Query
        String query = "SELECT * FROM SeleniumAutomation.book_detl";

        // Execute Query
        ResultSet rs = stmt.executeQuery(query);

        // Read data
        while (rs.next()) {

            String auth = rs.getString("author");
            String tit = rs.getString("title");

            System.out.println("Author: " + auth + ", Title: " + tit);
        }

        // Close connection
        rs.close();
        stmt.close();
        con.close();

        System.out.println("Database connection closed");
    }
}
