package main.java.factory.factorymethod;

/**
 *
 */
public class M {
    public static void main(String[] args) {
        System.out.println("The first customer order in Chicago pizza store");
        PizzaStore chicagoStylePizzaStore = new ChicagoStylePizzaStore();
        Pizza pizza = chicagoStylePizzaStore.orderPizza("cheese");

        System.out.println("The second customer order in NY pizza store");
        NYStylePizzaStore nyStylePizzaStore = new NYStylePizzaStore();
        nyStylePizzaStore.orderPizza("cheese");
    }
}
