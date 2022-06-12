package main.java.factory.factorymethod;

public class Pizza {
    /**
     * 名称
     */
    private String name;
    /**
     * 面团类型
     */
    private String dough;
    /**
     * 酱料类型
     */
    private String sauce;

    public void prepare() {
        System.out.println("Pizza prepare");
    }

    public void bake() {
        System.out.println("Pizza bake");
    }

    public void cut() {
        System.out.println("Pizza cut");
    }

    public void box() {
        System.out.println("Pizza box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        System.out.println(name);
        return name;
    }
}
