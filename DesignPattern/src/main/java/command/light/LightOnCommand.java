package command.light;


import command.Command;

/**
 * 包装开灯、关灯指令
 * ConcreteCommand
 */
public class LightOnCommand implements Command {
    Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
