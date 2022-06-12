package main.java.factory.simplefactory;


import main.java.factory.factorymethod.Pizza;

public class T {
    public static void main(String[] args) {
        // 1. 创建Pizza简单工厂
        SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
        // 2.根据type创建Pizza
        Pizza cheese = simplePizzaFactory.createPizza("veggie");
        // 3.得到Pizza
        cheese.toString();
    }
}
