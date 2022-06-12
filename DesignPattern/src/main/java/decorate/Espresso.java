package main.java.decorate;

/**
 * 被装饰者实现类
 * 浓咖啡
 */
public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
