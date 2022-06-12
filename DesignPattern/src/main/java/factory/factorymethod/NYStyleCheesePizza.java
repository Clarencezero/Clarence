package main.java.factory.factorymethod;

/**
 * @author Clarence
 * @date 2020-06-02 20:01
 */
public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {

        setName("NY Style Pizza");
    }
    @Override
    public String toString() {
        return "NYStyle Cheese Pizza make success!";
    }
}
