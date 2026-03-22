package Bai3;


//Phần 1
//Lệnh executeUpdate() trả về một số nguyên cho biết có bao nhiêu dòng trong bảng bị tác động bởi câu lệnh SQL.
//Nếu giá trị trả về là 0, nghĩa là không có bản ghi nào phù hợp với điều kiện WHERE (ví dụ: bed_id = 999 không tồn tại).

//Phần 2
import java.sql.*;

public class BedManagement {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/bed_db";
        String user = "your_username";
        String pass = "your_password";

        Connection conn = null;
        Statement stmt = null;

        int inputId = 999;

        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();

            String sql = "UPDATE Beds SET bed_status = 'Đang sử dụng' WHERE bed_id = " + inputId;
            int rowsAffected = stmt.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Đã cập nhật giường bệnh thành công!");
            } else {
                System.out.println("Mã giường " + inputId + " không tồn tại!");
            }

        } catch (SQLException e) {
            System.out.println("Lỗi cập nhật: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ignored) {

            } try {
                if (conn != null) conn.close();
            } catch (SQLException ignored) {

            }
        }
    }
}
