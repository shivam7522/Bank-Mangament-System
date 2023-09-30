package bank_management_system;

import java.sql.*;

public class Connn  {
    Connection connection;
    Statement statement;

    public Connn() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank_Management","root", "1234");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
