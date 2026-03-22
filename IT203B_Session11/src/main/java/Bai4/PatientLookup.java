package Bai4;

// Phần 1
//Mệnh đề WHERE full_name = '' OR '1'='1' sẽ luôn đúng vì biểu thức '1'='1' là true.
//Kết quả: câu lệnh không còn lọc theo tên bệnh nhân nữa mà trả về toàn bộ bảng Patients, dẫn đến rò rỉ dữ liệu.

//Phần 2
import java.sql.*;

public class PatientLookup {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/patient_db";
        String user = "your_username";
        String pass = "your_password";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String patientName = "' OR '1'='1";

        patientName = patientName.replace("'", "")
                .replace(";", "")
                .replace("--", "");

        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();

            String sql = "SELECT * FROM Patients WHERE full_name = '" + patientName + "'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("patient_id") + " | Tên: " + rs.getString("full_name"));
            }

        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException ignored) {

            } try {
                if (stmt != null) stmt.close();
            } catch (SQLException ignored) {

            } try {
                if (conn != null) conn.close();
            } catch (SQLException ignored) {

            }
        }
    }
}

