package strategy.duckcanfly;

/**
 * 不再把鸭子的行为说成「一组行为」，我们开始把行为想成是「一族算法」
 * 鸭子的行为不是继承而来，而是和适当的行为对象组合而来。
 * 设计原则: 多用组合，少用继承。
 */
public class T {
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();

        System.out.println("--------Nothing Duck--------------");
        NothingDuck nothingDuck = new NothingDuck();
        nothingDuck.performFly();
    }
}
