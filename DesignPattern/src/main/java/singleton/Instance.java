package singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class Instance {
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public Instance() {
        atomicInteger.getAndIncrement();
    }

    @Override
    public String toString() {
        return String.valueOf(atomicInteger.get());
    }
}
