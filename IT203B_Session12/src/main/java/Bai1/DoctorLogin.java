package Bai1;

// PreparedStatement bảo vệ bằng cách tách biệt lệnh và dữ liệu, còn cơ chế pre-compiled đảm bảo dữ liệu đầu vào không bao giờ trở thành một phần của lệnh SQL.

import java.sql.*;

public class DoctorLogin {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/doctor_db";
        String user = "your_username";
        String pass = "your_password";

        String doctorCode = "D001";
        String doctorPass = "123456";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT * FROM Doctors WHERE code = ? AND pass = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, doctorCode);
            ps.setString(2, doctorPass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Đăng nhập thành công");
            } else {
                System.out.println("Sai mã số hoặc mật khẩu!");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối hoặc truy vấn: " + e.getMessage());
        }
    }
}
