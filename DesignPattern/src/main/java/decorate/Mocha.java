package main.java.decorate;

/**
 * 摩卡是一个装饰者，对Beverage进行装饰
 * 该类清楚知道被装饰对象。因为需要持有被装饰对象引用
 * 1.持有被装饰者的引用
 * 2.保证被装饰者的方法签名的实现(getDescription())
 * 3.实现装饰(cost)
 */
public class Mocha extends CondimentDecorator{
    Beverage beverage;
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
