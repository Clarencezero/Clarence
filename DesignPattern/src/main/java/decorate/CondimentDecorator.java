package main.java.decorate;

/**
 * 装饰者抽象类
 * 所有的辅料都要继承该类
 * 必须让Condiment Decorator能取代Beverage
 */
public abstract class CondimentDecorator extends Beverage{
    /**
     * 所有子类必须重新实现该方法。因为装饰器需要保持被装饰者的类方法签名完整
     * @return
     */
    public abstract String getDescription();
}
