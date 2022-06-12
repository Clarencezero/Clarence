package command.macro;


import command.Command;

/**
 * 宏命令模式
 * 如果想按指定步骤撤回、可以通过栈进行操作行为保存
 */
public class MacroCommand implements Command {
    Command[] commands;;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {

    }
}
