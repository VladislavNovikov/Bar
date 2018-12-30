package app.javaclasses;

import java.sql.*;

public class tmp {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";
    private static final String URL = "jdbc:mysql://localhost:3306/nightstalker?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //driver = new com.mysql.cj.jdbc.Driver();
            // DriverManager.registerDriver(driver);
            // connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException  e) {
            System.out.println("ClassNotFoundException");
            //e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("insert into recip(name) values(?)")){

            String str = "1253";
            statement.setString(1,str);

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
