package strategy.duckcanfly;

/**
 * @author Clarence
 * @date 2020-06-01 10:03
 */
public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("定义会飞的鸭子行为!!!");
    }
}
