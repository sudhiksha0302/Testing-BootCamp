
package Database;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.Statement;



public class ReadBooksDetails {

public static void main(String[] args) {

        String databaseURL = "jdbc:mysql://localhost:3306/SeleniumAutomation";

        String user = "root";

        String password = "Sudhiksha@2006";      

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");        

            Connection con = DriverManager.getConnection(databaseURL, user, password);

            Statement stmt = con.createStatement();

            String query = "SELECT * FROM SeleniumAutomation.book_detl;";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("------------------------------------------------------------------------------------");

            System.out.printf("%-8s %-12s %-10s %-12s %-12s %-8s %-8s %-8s%n",

                    "BookNo","Title","Subject","Author","Publisher","Status","YOP","Price");

            System.out.println("------------------------------------------------------------------------------------");



            while(rs.next()) {

                String bookNo = rs.getString("book_no");

                String title = rs.getString("title");

                String subject = rs.getString("sub_code");

                String author = rs.getString("author");

                String publisher = rs.getString("publisher");

                String status = rs.getString("status");

                String yop = rs.getString("yop");

                double price = rs.getDouble("price");

                System.out.printf("%-8s %-12s %-10s %-12s %-12s %-8s %-8s %-8.2f%n",

                        bookNo, title, subject, author, publisher, status, yop, price);

            }

            rs.close();

            stmt.close();

            con.close();



        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}



/*

 * It consists of three parts:

 *

 * % → Indicates the start of a format specifier.

 * - → Left-aligns the value within the specified width.

 * 8 → Reserves 8 character spaces for the value.

 * s → Formats the value as a String.

 */