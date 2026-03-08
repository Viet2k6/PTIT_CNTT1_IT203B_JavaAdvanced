package Bai6;
import java.util.Scanner;
import java.io.IOException;
public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User3 user = new User3();
        try {
            System.out.print("Nhập tên: ");
            String name = sc.nextLine();
            user.setName(name);

            System.out.print("Nhập tuổi: ");
            int age = Integer.parseInt(sc.nextLine());

            user.setAge(age);

            if (user.getName() != null) {
                System.out.println("Tên người dùng: " + user.getName());
            }

            FileService.saveToFile(user);

        } catch (NumberFormatException e) {
            Logger.logError("Tuổi không hợp lệ");

        } catch (InvalidAgeException e) {
            Logger.logError(e.getMessage());

        } catch (IOException e) {
            Logger.logError("Không thể lưu file: " + e.getMessage());

        } finally {
            sc.close();
            System.out.println("Dọn dẹp tài nguyên.");
        }
    }
}