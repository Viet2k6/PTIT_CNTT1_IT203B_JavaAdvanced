package Bai3;

import java.util.HashMap;
import java.util.Map;

public class RemoteControl {
    private Map<Integer, Command> buttons = new HashMap<>();
    private UndoManager undoManager;

    public RemoteControl(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    public void setCommand(int button, Command command) {
        buttons.put(button, command);
        System.out.println("Đã gán lệnh cho nút " + button);
    }

    public void pressButton(int button) {
        Command command = buttons.get(button);
        if (command != null) {
            command.execute();
            undoManager.push(command);
        } else {
            System.out.println("Nút chưa được gán");
        }
    }
}