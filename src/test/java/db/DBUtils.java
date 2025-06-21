package db;

import java.sql.*;

public class DBUtils {
    public static boolean userExists(String phone) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hotel_db", "root", "root");
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT COUNT(*) FROM user_login WHERE phone = ?")) {

            stmt.setString(1, phone);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
