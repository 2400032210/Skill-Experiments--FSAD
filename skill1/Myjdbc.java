import java.sql.*;

public class Myjdbc {
    public static void main(String[] args) {
        try {
            // 1. Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "lokesh", "Loki@937"
            );

            // 3. Auto-commit ensures inserts are saved immediately
            con.setAutoCommit(true);

            // 4. Prepare statement once
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO user (id, name) VALUES(?, ?)");

            // 5. Insert first row
            pstmt.setInt(1, 47);
            pstmt.setString(2, "dam");
            pstmt.executeUpdate();

            // 6. Insert second row
            pstmt.setInt(1, 53);
            pstmt.setString(2, "Ravi");
            pstmt.executeUpdate();

            // 7. Insert third row
            pstmt.setInt(1, 54);
            pstmt.setString(2, "Kumar");
            pstmt.executeUpdate();

            pstmt.setInt(1, 57);
            pstmt.setString(2, "lokesh");
            pstmt.executeUpdate();

            System.out.println("Rows inserted");

            // 8. Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}