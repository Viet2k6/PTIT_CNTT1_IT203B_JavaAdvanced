package Bai5;

public class FanLow implements Command {
    private Fan fan;
    public FanLow(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        System.out.println("SleepMode: Quạt tốc độ thấp");
        fan.low();
    }
}