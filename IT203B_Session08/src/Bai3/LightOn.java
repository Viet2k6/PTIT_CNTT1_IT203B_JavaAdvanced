package Bai3;

public class LightOn implements Command {
    private Light light;

    public LightOn(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        System.out.print("Undo: ");
        light.off();
    }
}