package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtil {
	private static Connection connection = null;
	public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                              
                String user = "postgres";
                String password = "0715";
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clientdb",user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

}
}
