package Bai5;

public class LightOff implements Command {
    private Light light;
    public LightOff(Light light) {
        this.light = light;
    }

    public void execute() {
        System.out.println("SleepMode: Tắt đèn");
        light.off();
    }
}