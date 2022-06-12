package main.java.factory.factorymethod;

/**
 */
public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        setName("Chicago style cheese pizza");
    }
    @Override
    public String toString() {
        return "Chicago style Cheese Pizza make success!";
    }
}
