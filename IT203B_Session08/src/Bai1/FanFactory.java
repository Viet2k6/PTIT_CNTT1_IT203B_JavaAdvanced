package Bai1;

public class FanFactory extends DeviceFactory {
    public Device createDevice() {
        System.out.println("Đã tạo quạt mới.");
        return new Fan();
    }
}