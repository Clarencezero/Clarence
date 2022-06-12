package main.java.decorate;

/**
 * 1.持有被装饰者的引用
 * 2.保证被装饰者的方法签名的实现(getDescription())
 * 3.实现装饰(cost)
 */
public class Whip extends CondimentDecorator{
    Beverage beverage;
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return .66 + beverage.cost();
    }
}
