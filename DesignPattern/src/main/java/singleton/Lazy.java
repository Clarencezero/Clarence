package singleton;

public class Lazy {
    private static Instance instance;
    private Lazy() {}
    public static Instance getInstance() {
        if (instance == null) {
            instance = new Instance();
        }
        return instance;
    }
}
