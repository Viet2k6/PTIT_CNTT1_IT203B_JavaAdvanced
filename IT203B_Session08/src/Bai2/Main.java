package Bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SmartHomeFacade facade = new SmartHomeFacade();
        TemperatureSensor sensor = new ThermometerAdapter(new OldThermometer());
        while (true) {
            System.out.println("1. Xem nhiệt độ");
            System.out.println("2. Chế độ rời nhà");
            System.out.println("3. Chế độ ngủ");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    facade.getCurrentTemperature(sensor);
                    break;
                case 2:
                    facade.leaveHome();
                    break;
                case 3:
                    facade.sleepMode();
                    break;
                case 4:
                    System.out.println("Thoát.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}