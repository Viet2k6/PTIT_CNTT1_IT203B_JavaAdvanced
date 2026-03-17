package Bai1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Device device = null;
        HardwareConnection connection = null;
        while (true) {
            System.out.println("1. Kết nối phần cứng");
            System.out.println("2. Tạo thiết bị");
            System.out.println("3. Điều khiển thiết bị (Bật/Tắt)");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    connection = HardwareConnection.getInstance();
                    connection.connect();
                    break;

                case 2:
                    System.out.println("Chọn loại: 1. Đèn  2. Quạt  3. Điều hòa");
                    int type = sc.nextInt();
                    switch (type) {
                        case 1:
                            device = new LightFactory().createDevice();
                            break;
                        case 2:
                            device = new FanFactory().createDevice();
                            break;
                        case 3:
                            device = new AirConditionerFactory().createDevice();
                            break;
                        default:
                            System.out.println("Loại không hợp lệ");
                    }
                    break;

                case 3:
                    if (device == null) {
                        System.out.println("Chưa có thiết bị");
                        break;
                    }
                    System.out.println("1. Bật");
                    System.out.println("2. Tắt");
                    System.out.print("Chọn: ");
                    int action = sc.nextInt();
                    switch (action) {
                        case 1:
                            device.turnOn();
                            break;
                        case 2:
                            device.turnOff();
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ");
                    }
                    break;

                case 4:
                    System.out.println("Thoát");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}