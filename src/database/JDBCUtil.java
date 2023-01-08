package database;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    public static Connection getConnection() {

        Connection connection = null;

        try {

            // dang ky MySQL  Driver vs Driver Manager
            DriverManager.registerDriver(new Driver());

            // ket noi toi database
            String url = "jdbc:mySQL://localhost:3306/JDBC_Connection";
            String username = "root";
            String password = "root";

            // tao ket noi
            connection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  connection;
    }

    public static void closeConnection(Connection connection) {

        if (connection != null) {
            try {
                DatabaseMetaData databaseMetaData = connection.getMetaData();

                System.out.println(databaseMetaData.getDatabaseProductName());
                System.out.println(databaseMetaData.getDatabaseProductVersion());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
