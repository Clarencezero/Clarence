package command;

/**
 * 使用命令对象
 * 假设只有一个遥控器，它只有一个按钮和对应的插槽，可以控制一个装置。
 * Invoker
 */
public class RemoteControl {
    // 有一个插槽持有命令，而这个命令控制着一个着墨
    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoCommand;
    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    /**
     * 设置插槽控制的命令。
     */
    public void setCommand(int slot, Command onComand, Command offCommand) {
        onCommands[slot] = onComand;
        offCommands[slot] = offCommand;
    }

    /**
     * 当按下按钮时，这个方法就会被调用。使得当前命令衔接插槽，并调用它的`execute()`方法
     */
    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
        System.out.println("UNDO");
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n-------- Remote Control ---------\n");
        for (int i = 0; i < onCommands.length; i++) {
            if (onCommands[i] == null) {
                continue;
            }
            sb.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "    " + offCommands[i].getClass().getName() + "\n");
        }
        return sb.toString();
    }
}
