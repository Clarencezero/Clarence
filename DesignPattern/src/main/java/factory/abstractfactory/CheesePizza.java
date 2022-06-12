package main.java.factory.abstractfactory;

/**
 * 具体Pizza实现类
 *
 */
public class CheesePizza extends Pizza{

    PizzaIngredientFactory ingredientFactory;
    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.ingredientFactory = pizzaIngredientFactory;
    }

    /**
     * 重写Pizza 原料准备方法。不同类型的Pizza准备不同原料
     */
    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
