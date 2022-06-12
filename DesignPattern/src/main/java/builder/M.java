package builder;

/**
 *
 */
public class M {
    public static void main(String[] args) {
        ResourcePoolConfig resourcePoolConfig = new ResourcePoolConfig.Builder()
                .setName("张三")
                .setMaxIdle(4)
                .setMaxTotal(6)
                .setMinIdle(1)
                .build();
    }
}
