package Bai2;


// PreparedStatement giúp chuẩn hóa dữ liệu số, không bị ảnh hưởng bởi dấu chấm/dấu phẩy của hệ điều hành.

import java.sql.*;

public class VitalsUpdate {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String user = "your_username";
        String pass = "your_password";

        int patientId = 101;
        double temperature = 37.5;
        int heartRate = 80;

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "UPDATE Vitals SET temperature = ?, heart_rate = ? WHERE p_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, temperature);
            ps.setInt(2, heartRate);
            ps.setInt(3, patientId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Cập nhật chỉ số sinh tồn thành công cho bệnh nhân ID " + patientId);
            } else {
                System.out.println("Không tìm thấy bệnh nhân với ID " + patientId);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi cập nhật: " + e.getMessage());
        }
    }
}