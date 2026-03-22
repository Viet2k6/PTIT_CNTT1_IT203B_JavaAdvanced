package Bai5.presentation;

import Bai5.business.DoctorService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoctorService service = new DoctorService();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----- Bệnh viện Rikkei-Care -----");
            System.out.println("1. Xem danh sách bác sĩ");
            System.out.println("2. Thêm bác sĩ mới");
            System.out.println("3. Thống kê chuyên khoa");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    service.showAllDoctors();
                    break;
                case 2:
                    System.out.print("Nhập mã bác sĩ: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập họ tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập chuyên khoa: ");
                    String specialty = sc.nextLine();
                    service.addDoctor(id, name, specialty);
                    break;
                case 3:
                    service.statistic();
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}

