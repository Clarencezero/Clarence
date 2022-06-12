package adaptor.classadaptor;

public class Adaptee {
    /**
     * Info 级别
     * @param msg
     */
    public void slf4jInfo(String msg) {
        System.out.println("[Adaptee INFO]: " + msg);
    }

    /**
     * debug级别
     * @param msg
     */
    public void slf4jDebug(String msg) {
        System.out.println("[Adaptee DEBUG]: " + msg);
    }
}
