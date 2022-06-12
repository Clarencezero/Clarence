package main.java.factory.abstractfactory;


/**
 * Pizza店 抽象类
 */
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /**
     * ① 工厂方法是抽象的。所以依赖子类来处理对象的创建
     * ② 必须返回一个产品
     * ③ 工厂方法有可能需要参数，也有可能不需要参数来指定所需要的产品
     * @param type
     * @return
     */
    protected abstract Pizza createPizza(String type);
}
