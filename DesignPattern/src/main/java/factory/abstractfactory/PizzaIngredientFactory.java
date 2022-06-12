package main.java.factory.abstractfactory;

/**
 * Pizza 原料工厂接口
 * 定义如何产生一个相关产品的家族。这个家族包含了所有制作Pizza的原料
 */
public interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();
}
