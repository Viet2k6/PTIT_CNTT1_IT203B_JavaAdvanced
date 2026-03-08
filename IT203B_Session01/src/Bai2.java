import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhập tổng số người: ");
            int tongNguoi = sc.nextInt();

            System.out.print("Nhập số nhóm: ");
            int soNhom = sc.nextInt();

            int moiNhom = tongNguoi / soNhom;

            System.out.println("Mỗi nhóm có: " + moiNhom + " người");

        } catch (ArithmeticException e) {
            System.out.println("Không thể chia cho 0");
        }

        System.out.println("Kết thúc chương trình");
        sc.close();
    }
}