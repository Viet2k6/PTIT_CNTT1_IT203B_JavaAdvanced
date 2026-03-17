package Bai3;

public class LightOff implements Command {
    private Light light;

    public LightOff(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }

    public void undo() {
        System.out.print("Undo: ");
        light.on();
    }
}