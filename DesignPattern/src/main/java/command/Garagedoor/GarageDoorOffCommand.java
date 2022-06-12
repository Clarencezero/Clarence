package command.Garagedoor;


import command.Command;

/**
 */
public class GarageDoorOffCommand implements Command {
    private GarageDoor garageDoor;

    public GarageDoorOffCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.off();
    }

    @Override
    public void undo() {
        garageDoor.on();
    }
}
