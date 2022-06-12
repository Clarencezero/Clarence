package strategy.duckcanfly;

/**
 * @author Clarence
 * @date 2020-06-01 10:04
 */
public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("定义会呱呱叫的鸭子行为!!!");
    }
}
