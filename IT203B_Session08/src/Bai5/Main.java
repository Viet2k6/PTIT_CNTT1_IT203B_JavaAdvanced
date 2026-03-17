package Bai5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        TemperatureSensor sensor = new TemperatureSensor();
        sensor.attach(fan);
        sensor.attach(ac);

        Command sleepMode = new SleepModeCommand(Arrays.asList(
                new LightOff(light),
                new ACSetTempCommand(ac),
                new FanLow(fan)
        ));

        while (true) {
            System.out.println("1. Kích hoạt chế độ ngủ");
            System.out.println("2. Thay đổi nhiệt độ");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sleepMode.execute();
                    break;
                case 2:
                    System.out.print("Nhập nhiệt độ: ");
                    int temp = sc.nextInt();
                    sensor.setTemperature(temp);
                    break;
                case 3:
                    System.out.println("Thoát.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}