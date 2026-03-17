package Bai5;

public class ACSetTempCommand implements Command {
    private AirConditioner ac;
    public ACSetTempCommand(AirConditioner ac) {
        this.ac = ac;
    }

    public void execute() {
        System.out.println("SleepMode: Điều hòa set 28°C");
        ac.setTemperature(28);
    }
}