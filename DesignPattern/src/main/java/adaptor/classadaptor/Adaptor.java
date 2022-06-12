package adaptor.classadaptor;

/**
 * 类适配器
 */
public class Adaptor extends Adaptee implements Logger{
    @Override
    public void info(String msg) {
        slf4jInfo(msg);
    }

    @Override
    public void debug(String msg) {
        slf4jDebug(msg);
    }
}
