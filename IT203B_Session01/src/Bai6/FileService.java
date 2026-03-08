package Bai6;
import java.io.IOException;
class FileService {
    public static void saveToFile(User3 user) throws IOException {
        System.out.println("Đang lưu dữ liệu vào file");
        throw new IOException("Lỗi khi ghi file");
    }
}