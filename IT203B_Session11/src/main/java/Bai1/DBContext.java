package Bai1;
import java.sql.*;

//Phần 1
//Việc khởi tạo kết nối liên tục mà không đóng (Close) gây nguy hiểm cho hệ thống y tế hoạt động 24/7 vì:
//   Gây rò rỉ kết nối (connection leak), làm cạn kiệt số lượng kết nối của Database.
//   Khi đạt giới hạn, hệ thống không thể tạo thêm kết nối mới, dẫn đến tình trạng treo hoặc ngừng hoạt động.
//   Các kết nối cũ có thể bị timeout nhưng vẫn được giữ lại, gây lỗi "Communications link failure" khi sử dụng.
//   Trong hệ thống y tế, việc không truy xuất được dữ liệu bệnh nhân kịp thời có thể ảnh hưởng nghiêm trọng đến quá trình khám chữa bệnh.

//Phần 2
public class DBContext {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/Hospital_DB";
        private static final String USER = "your_username";
        private static final String PASS = "your_password";


        public Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASS);
        }

        public void testConnection() {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                conn = getConnection();
                stmt = conn.createStatement();

                String sql = "SELECT 1";
                rs = stmt.executeQuery(sql);

                if (rs.next()) {
                    System.out.println("Kết nối và truy vấn thành công");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if (stmt != null) stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if (conn != null) {
                        conn.close();
                        System.out.println("Đóng kết nối an toàn");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        public static void main(String[] args) {
            DBContext db = new DBContext();
            db.testConnection();
        }
}