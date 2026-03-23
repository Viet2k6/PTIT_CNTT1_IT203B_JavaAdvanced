package Bai5;

import Bai5.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital_db";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT patient_id, full_name, age, department, medical_record FROM Patients";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Patient(
                        rs.getInt("patient_id"),
                        rs.getString("full_name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getString("medical_record")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi lấy danh sách: " + e.getMessage());
        }
        return list;
    }

    public void addPatient(String name, int age, String dept) {
        String sql = "INSERT INTO Patients(full_name, age, department) VALUES(?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, dept);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Lỗi thêm bệnh nhân: " + e.getMessage());
        }
    }

    public void updateRecord(int id, String record) {
        String sql = "UPDATE Patients SET medical_record = ? WHERE patient_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, record);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Lỗi cập nhật bệnh án: " + e.getMessage());
        }
    }

    public double discharge(int id) {
        double fee = 0;
        try (Connection conn = getConnection();
             CallableStatement cstmt = conn.prepareCall("{call CALCULATE_DISCHARGE_FEE(?, ?)}")) {
            cstmt.setInt(1, id);
            cstmt.registerOutParameter(2, Types.DECIMAL);
            cstmt.execute();
            fee = cstmt.getDouble(2);
        } catch (SQLException e) {
            System.out.println("Lỗi xuất viện: " + e.getMessage());
        }
        return fee;
    }
}
