package Bai3;

@FunctionalInterface
public interface Authenticatable {
    // Phương thức trừu tượng
    String getPassword();

    // Phương thức mặc định: kiểm tra mật khẩu không rỗng
    default boolean isAuthenticated() {
        return getPassword() != null && !getPassword().isEmpty();
    }

    // Phương thức tĩnh: mô phỏng mã hóa mật khẩu
    static String encrypt(String rawPassword) {
        // Ví dụ đơn giản: đảo ngược chuỗi
        return new StringBuilder(rawPassword).reverse().toString();
    }
}