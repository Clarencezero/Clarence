package main.java.factory.simplefactory;


import main.java.factory.factorymethod.Pizza;

/**
 * Pizza 简单工厂类
 */
public class SimplePizzaFactory {
    /**
     * 根据不同pizza类型创建对应Pizza
     * @param type
     * @return
     */
    public Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new CheesePizza();
        } else if (type.equals("veggie")) {
            return new Veggie("veggiePizza");
        } else {
            return null;
        }
    }
}
