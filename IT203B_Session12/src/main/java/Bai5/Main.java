package Bai5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PatientService service = new PatientService();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Danh sách bệnh nhân");
            System.out.println("2. Tiếp nhận bệnh nhân mới");
            System.out.println("3. Cập nhật bệnh án");
            System.out.println("4. Xuất viện & Tính phí");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    service.showAllPatients();
                    break;
                case 2:
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Khoa: ");
                    String dept = sc.nextLine();
                    service.addPatient(name, age, dept);
                    break;
                case 3:
                    System.out.print("ID bệnh nhân: ");
                    int idUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Bệnh án mới: ");
                    String record = sc.nextLine();
                    service.updateRecord(idUpdate, record);
                    break;
                case 4:
                    System.out.print("ID bệnh nhân: ");
                    int idDischarge = sc.nextInt();
                    service.discharge(idDischarge);
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}