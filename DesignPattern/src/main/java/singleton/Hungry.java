package singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Hungry {
    private static Instance instance = new Instance();

    private Hungry() {}

    public static Instance getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> System.out.println(Hungry.getInstance().toString()));
        }
    }
}
