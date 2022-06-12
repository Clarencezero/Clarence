package main.java.factory.abstractfactory;

/**
 *
 */
public class T {
    public static void main(String[] args) {
        // 创建纽约Pizza店
        PizzaStore pizzaStore = new NYPizzaStore();
        // 接受订单
        pizzaStore.orderPizza("cheese");
    }
}
