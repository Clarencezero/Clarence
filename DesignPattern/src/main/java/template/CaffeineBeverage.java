package template;

/**
 * 抽象类: 作为基类，其子类必须实现抽象方法
 */
public abstract class CaffeineBeverage {
    /**
     * 整个流程处理
     * 声明为final以免子类改变这个算法的顺序
     */
    final void prepareRecipe() {
        // 把水煮沸
        boilWater();
        // 用热水泡咖啡或茶
        brew();
        // 把饮料倒进杯子
        pourInCup();
        // 在饮料内加入适当的调料
        addCondiments();
    }

    abstract void brew();
    abstract void addCondiments();

    void boilWater() {
        System.out.println("boil water. Both.");
    }

    void pourInCup() {
        System.out.println("pour in cup. Both");
    }

}
