package Db;
import java.sql.*;

public class DBconnection {
    private static Connection conn;
    private static final String url = "jdbc:mysql://localhost:3306/hoteldb";
    private static final String username = "sqluser";
    private static final String password = "password";
        


    public static Connection getConnection() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(url, username, password);
        }
        return conn;
    }
    public PreparedStatement createPreparedStatement(String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
  
}

