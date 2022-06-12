package command.Garagedoor;

import command.Command;

/**
 */
public class GarageDoorOnCommand implements Command {
    private GarageDoor garageDoor;

    public GarageDoorOnCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.on();
    }

    @Override
    public void undo() {
        garageDoor.off();
    }
}
