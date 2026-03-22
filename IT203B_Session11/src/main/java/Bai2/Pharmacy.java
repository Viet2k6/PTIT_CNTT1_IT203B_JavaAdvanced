package Bai2;

//Phần 1
// Lệnh if chỉ kiểm tra một lần duy nhất xem có bản ghi hay không. Nếu có, nó in ra bản ghi đầu tiên rồi kết thúc.
// Con trỏ của ResultSet ban đầu nằm trước dòng đầu tiên.
// Mỗi lần gọi rs.next() thì con trỏ sẽ dịch sang bản ghi kế tiếp. Nếu còn dữ liệu thì trả về true, nếu hết dữ liệu thì trả về false.
// Vì chỉ dùng if, chương trình không lặp qua toàn bộ các bản ghi, nên chỉ in ra đúng một thuốc đầu tiên.


//Phần 2
import java.sql.*;

public class Pharmacy {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/pharmacy_db";
        String user = "your_username";
        String pass = "your_password";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, pass);

            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy");

            while (rs.next()) {
                String name = rs.getString("medicine_name");
                int stock = rs.getInt("stock");
                System.out.println("Thuốc: " + name + " | Số lượng tồn: " + stock);
            }

        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException ignored) {}

            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ignored) {}

            try {
                if (conn != null) conn.close();
            } catch (SQLException ignored) {}
        }
    }
}
