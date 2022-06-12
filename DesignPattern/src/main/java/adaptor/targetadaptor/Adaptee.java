package adaptor.targetadaptor;

public class Adaptee {
    public void info(String msg) {
        System.out.println("[INFO]底层日志实现: Log4J2. " + msg);
    }

    public void debug(String msg) {
        System.out.println("[DEBUG]底层日志实现: Log4J2. " + msg);
    }
}
