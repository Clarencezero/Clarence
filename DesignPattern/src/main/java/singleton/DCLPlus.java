package singleton;

public class DCLPlus {
    private volatile static Instance instance;
    private DCLPlus() {}

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (DCLPlus.class) {
                if (instance == null) {
                    instance = new Instance();
                }
            }
        }
        return instance;
    }
}
