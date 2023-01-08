package test;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.Statement;

public class TestJDBCUtil {
    public static void main(String[] args) {


        try {

            // tao ket noi
            Connection connection = JDBCUtil.getConnection();

            // tao doi tuong statement
            Statement statement = connection.createStatement();

            // query sql
            String sql = "insert into Student (name, age)\n" +
                    "values ('Uy', 18)";

            int check = statement.executeUpdate(sql);

            System.out.println("Changed row: " + check);

            if (check > 0) {
                System.out.println("Data was changed");
            } else {
                System.out.println("No change");
            }

            // ngat ket noi
            JDBCUtil.closeConnection(connection);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
