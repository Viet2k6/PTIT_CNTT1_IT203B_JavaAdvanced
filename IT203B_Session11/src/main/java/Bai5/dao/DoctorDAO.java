package Bai5.dao;

import Bai5.model.Doctor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/doctor_db";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT doctor_id, full_name, specialty FROM Doctors";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Doctor(
                        rs.getString("doctor_id"),
                        rs.getString("full_name"),
                        rs.getString("specialty")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn: " + e.getMessage());
        }
        return list;
    }


    public void addDoctor(Doctor d) {
        String sql = "INSERT INTO Doctors(doctor_id, full_name, specialty) VALUES('" + d.getId() + "','" + d.getName() + "','" + d.getSpecialty() + "')";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("Thêm bác sĩ thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi thêm bác sĩ: " + e.getMessage());
        }
    }

    public void statisticBySpecialty() {
        String sql = "SELECT specialty, COUNT(*) as total FROM Doctors GROUP BY specialty";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("Chuyên khoa: " + rs.getString("specialty") + " | Số lượng: " + rs.getInt("total"));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi thống kê: " + e.getMessage());
        }
    }
}
