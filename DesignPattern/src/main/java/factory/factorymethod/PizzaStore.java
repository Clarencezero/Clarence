package main.java.factory.factorymethod;

/**
 * PizzaStore 作为超类，可以被其他
 * 各个加盟店之间的区别在于风味不同，而其它流程我们认为是相同的
 */
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);
        System.out.println(pizza.getName());
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
