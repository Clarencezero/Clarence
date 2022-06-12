package main.java.factory.abstractfactory;

/**
 * Pizza超类
 * 在这个类里面包含了Pizaz的制作流程、原料类型
 */
public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Cheese cheese;

    /**
     * 在这个方法中我们收集
     */
    abstract void prepare();

    void bake() {
        System.out.println("bake for 25 minutes");
    }

    void cut() {
        System.out.println("cut for 1 minutes");
    }
    void box() {
        System.out.println("box for 1 minutes ");
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
