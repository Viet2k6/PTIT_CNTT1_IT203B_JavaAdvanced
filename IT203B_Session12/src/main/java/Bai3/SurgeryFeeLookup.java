package Bai3;


//JDBC bắt buộc phải registerOutParameter() để biết kiểu dữ liệu và vị trí tham số OUT. Với SQL kiểu DECIMAL thì dùng Types.DECIMAL.


import java.sql.*;

public class SurgeryFeeLookup {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String user = "your_username";
        String pass = "your_password";

        int surgeryId = 505;

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            CallableStatement cstmt = conn.prepareCall("{call GET_SURGERY_FEE(?, ?)}");

            cstmt.setInt(1, surgeryId);
            cstmt.registerOutParameter(2, Types.DECIMAL);

            cstmt.execute();

            double totalCost = cstmt.getDouble(2);
            System.out.println("Chi phí phẫu thuật cho ID " + surgeryId + " là: " + totalCost);

        } catch (SQLException e) {
            System.out.println("Lỗi khi gọi thủ tục: " + e.getMessage());
        }
    }
}
