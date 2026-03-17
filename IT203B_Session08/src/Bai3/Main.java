package Bai3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Light light = new Light();
        AirConditioner ac = new AirConditioner();
        UndoManager undoManager = new UndoManager();
        RemoteControl remote = new RemoteControl(undoManager);
        while (true) {
            System.out.println("1. Gán nút");
            System.out.println("2. Nhấn nút");
            System.out.println("3. Undo");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Chọn nút:");
                    int btn = sc.nextInt();
                    System.out.println("1. Bật đèn");
                    System.out.println("2. Tắt đèn");
                    System.out.println("3. Set điều hòa");
                    int type = sc.nextInt();
                    Command cmd = null;
                    switch (type) {
                        case 1:
                            cmd = new LightOn(light);
                            System.out.println("Đã gán LightOnCommand cho nút " + btn);
                            break;
                        case 2:
                            cmd = new LightOff(light);
                            System.out.println("Đã gán LightOffCommand cho nút " + btn);
                            break;
                        case 3:
                            System.out.print("Nhập nhiệt độ: ");
                            int temp = sc.nextInt();
                            cmd = new ACSetTemperatureCommand(ac, temp);
                            System.out.println("Đã gán ACSetTemperatureCommand(" + temp + ") cho nút " + btn);
                            break;
                    }
                    remote.setCommand(btn, cmd);
                    break;

                case 2:
                    System.out.print("Nhấn nút: ");
                    int press = sc.nextInt();
                    remote.pressButton(press);
                    break;

                case 3:
                    undoManager.undo();
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