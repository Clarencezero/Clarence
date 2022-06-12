package main.java.decorate;

/**
 * 饮料抽象类
 * 被装饰者抽象类
 */
public abstract class Beverage {
    /**
     * 描述字段
     */
    String description = "Unknown Beverage";
    public String getDescription() {
        return description;
    }

    /**
     * 待每个不同类型的子类实现的方法
     * @return
     */
    public abstract double cost();
}
