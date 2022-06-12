package main.java.factory.abstractfactory;

/**
 * Pizza店具体实例
 * 是抽象工厂的客户
 */
public class NYPizzaStore extends PizzaStore{
    /**
     * 根据类型创建Pizza
     * @param type
     * @return
     */
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        // 通过
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
            return pizza;
        }
        return null;
    }
}