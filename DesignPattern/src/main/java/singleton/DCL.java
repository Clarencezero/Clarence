package singleton;

public class DCL {
    private static Instance instance;
    private DCL() {}

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (DCL.class) {
                if (instance == null) {
                    instance = new Instance();
                }
            }
        }
        return instance;
    }
}
