package adaptor.targetadaptor;

/**
 * 适配器持有被适配者的引用
 */
public class LogAdaptor implements Logger{
    Adaptee log4J = new Adaptee();
    @Override
    public void info(String msg) {
        log4J.info(msg);
    }

    @Override
    public void debug(String msg) {
        log4J.debug(msg);
    }
}
