package adaptor.targetadaptor;

/**
 * 定义日志接口
 */
public interface Logger {
    /**
     * Info 级别
     * @param msg
     */
    void info(String msg);

    /**
     * debug级别
     * @param msg
     */
    void debug(String msg);
}
