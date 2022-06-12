package command;

/**
 * 命令定义
 */
public interface Command {
    /**
     * 执行命令
     */
    void execute();

    /**
     * 回退命令
     */
    void undo();
}
