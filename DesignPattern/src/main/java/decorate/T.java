package main.java.decorate;

/**
 */
public class T {
    public static void main(String[] args) {
        // 创建基础类
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());
        // 用摩卡装饰
        Mocha mocha = new Mocha(beverage);
        System.out.println(mocha.getDescription() + " $" + mocha.cost());
        // 用Whip装饰Mocha
        Whip whip = new Whip(mocha);
        System.out.println(whip.getDescription() + " $" + whip.cost());
    }
}
