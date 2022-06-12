package strategy.duckcanfly;

/**
 * 绿头鸭子
 */
public class MallardDuck extends Duck{
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    public void display() {
        System.out.printf("mallard duck.");
    }
}
