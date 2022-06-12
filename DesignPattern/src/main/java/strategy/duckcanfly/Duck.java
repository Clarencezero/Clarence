package strategy.duckcanfly;

/**
 * 鸭子超类
 * 需求一: 需要会飞的鸭子。
 *      会飞这个动作并不是所有鸭子都具备的行为。如果在超类上加上新的行为，将会使得某些子类具有这个不恰当的行为。
 *   方式一: 定义新的接口。让需要的这种鸭子行为的类实现它。但这不是一个好的办法。每当新增一个鸭子的种类，都要去实现这个接口。×
 *   如果每次新的需求一来，都会变化到某方面的代码，那么你可以确定，这部分的代码需要被抽取出来。
 *   方式二: 为要要区分开 变化和不变化的部分。准备再组类。一是fly相关，一是quack相关
 *   当我们创建特定对象的时候，指定特定的类型的飞行行为给它。我们需要在鸭子超类中包含设定行为了方法。就可以在运行时动态地改变子类的飞行行为
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    /**
     * 外观不同，定义抽象方法让子类实现
     */
    public abstract void display();

    /**
     * 呱呱叫
     */
    public void quack() {
        System.out.println("所有鸭子都会: 呱呱叫!!!");
    }
    /**
     * 游泳
     */
    public void swim() {
        System.out.println("所有鸭子都会: 游泳!!!");
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

}
