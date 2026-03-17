package Bai1;

public class AirConditionerFactory extends DeviceFactory {
    public Device createDevice() {
        System.out.println("Đã tạo điều hòa mới.");
        return new AirConditioner();
    }
}