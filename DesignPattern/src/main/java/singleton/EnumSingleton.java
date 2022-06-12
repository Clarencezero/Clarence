package singleton;

public enum  EnumSingleton {
    INSTANCE;
    public Instance getInstance() {
        return new Instance();
    }
}
