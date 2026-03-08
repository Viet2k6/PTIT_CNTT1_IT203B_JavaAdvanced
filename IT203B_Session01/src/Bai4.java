import java.io.IOException;

public class Bai4 {
    public static void saveToFile() throws IOException {
        System.out.println("Đang lưu dữ liệu vào file");
        throw new IOException("Lỗi khi ghi file");
    }

    public static void processUserData() throws IOException {
        System.out.println("Dữ liệu đang được xử lý");
        saveToFile();
    }

    public static void main(String[] args) {
        try {
            processUserData();
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        System.out.println("Kết thúc chương trình");
    }
}