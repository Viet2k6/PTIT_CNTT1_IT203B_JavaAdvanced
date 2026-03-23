package Bai4;


// Khi bạn dùng Statement và nối chuỗi trong vòng lặp, mỗi lần thực thi thì Database Server phải phân tích cú pháp (Parse) và lập kế hoạch thực thi (Execution Plan) lại từ đầu cho cùng một cấu trúc câu lệnh.
// Điều này làm tốc độ chậm đi rõ rệt, đặc biệt khi số lượng bản ghi lớn, vì DB không tái sử dụng kế hoạch thực thi đã có.
import java.sql.*;
import java.util.List;

public class BulkInsertResults {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String user = "your_username";
        String pass = "your_password";

        List<TestResult> list = List.of(
                new TestResult("Kết quả A"),
                new TestResult("Kết quả B"),
                new TestResult("Kết quả C")
        );

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "INSERT INTO Results(data) VALUES(?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            for (TestResult tr : list) {
                ps.setString(1, tr.getData());
                ps.executeUpdate();
            }

            System.out.println("Nạp kết quả xét nghiệm thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi nạp dữ liệu: " + e.getMessage());
        }
    }
}

class TestResult {
    private String data;
    public TestResult(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }
}
