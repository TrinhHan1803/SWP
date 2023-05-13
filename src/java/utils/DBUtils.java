
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtils {
    
    private static final String USER_NAME="sa";
    private static final String PASSWORD="12345";
    
    public static Connection getConnnection() throws ClassNotFoundException, SQLException{
        Connection conn=null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433;databaseName=assignment";
        conn=DriverManager.getConnection(url, USER_NAME, PASSWORD);
        return conn;
    }
}
