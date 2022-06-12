package singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class StaticInner {
    AtomicInteger atomicInteger = new AtomicInteger(0);
    private StaticInner() {}

    private static class SingleonHolder {
        private static final Instance instance = new Instance();
    }

    public static Instance getInstance() {
        return SingleonHolder.instance;
    }

    @Override
    public String toString() {
        return String.valueOf(atomicInteger.get());
    }

    public static void main(String[] args) {
        String o = StaticInner.getInstance().toString();
        System.out.println(o);
    }
}
