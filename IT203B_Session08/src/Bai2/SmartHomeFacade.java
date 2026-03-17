package Bai2;

public class SmartHomeFacade {

    public void leaveHome() {
        System.out.println("Tắt đèn");
        System.out.println("Tắt quạt");
        System.out.println("Tắt điều hòa");
    }

    public void sleepMode() {
        System.out.println("Tắt đèn");
        System.out.println("Điều hòa set 28°C");
        System.out.println("Quạt chạy tốc độ thấp");
    }

    public void getCurrentTemperature(TemperatureSensor sensor) {
        double temp = sensor.getTemperatureCelsius();
        System.out.printf("Nhiệt độ hiện tại: %.1f°C\n", temp);
    }
}