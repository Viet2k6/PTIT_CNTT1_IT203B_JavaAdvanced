package Bai1;

public class LightFactory extends DeviceFactory {
    public Device createDevice() {
        System.out.println("Đã tạo đèn mới.");
        return new Light();
    }
}