package proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * 1. 动态代理之所以称为动态: 是因为在运行时才将它的类创建出来。代码开始执行时，还没有proxy类，它是根据需要从你传入的接口集创建的。
 * 2. InvocationHandle不是proxy，它只是一个帮助proxy的类，proxy会把调用转发给它处理。Proxy本身是复用静态的Proxy.newProxyInstance()方法在运行时动态地创建的。
 * 3. 对于newProxyInstance()的接口数据。如果接口不是public，就必须属于同一个package，不同的接口内，不可以有名称和参数完全一样的方法。
 * 4. 动态代理有点像工厂模式，对于不同的需要被代理的对象产生对应的代理对象。
 */
public class M {
    public static void main(String[] args) {
        PersonBean joe = getJoe();
        PersonBean ownerProxy = getOwnerProxy(joe);
        System.out.println("姓名: " + joe.getName());
        ownerProxy.setInterest("我喜欢篮球");
        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("不能自己设定评分哦，需要别人对自己评分才有意义");
        }
        System.out.println("当前Joe评分:" + joe.getHotOrNotRating());

        PersonBean nonProxy = getNonProxy(joe);
        System.out.println("姓名: " + nonProxy.getName());
        nonProxy.setHotOrNotRating(10);
        try {
            nonProxy.setInterest("hey");
        } catch (Exception e) {
            System.out.println("当前兴趣爱好不能被其他人设置");
        }
        System.out.println("当前评分: " + nonProxy.getHotOrNotRating());

    }

    public static PersonBean getTom() {
        PersonBean joe = new PersonImpl();
        joe.setName("Tom");
        joe.setGender("Man");
        joe.setHotOrNotRating(1);
        joe.setInterest("Painting");
        return joe;
    }

    public static PersonBean getJoe() {
        PersonBean joe = new PersonImpl();
        joe.setName("Joe");
        joe.setGender("Man");
        joe.setHotOrNotRating(1);
        joe.setInterest("Painting");
        return joe;
    }

    public static PersonBean getOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(), personBean.getClass().getInterfaces(), new OwnerInvocationHandler(personBean));
    }

    public static PersonBean getNonProxy(PersonBean personBean) {
        System.setProperty("jdk.proxy.debug", "true");
        return (PersonBean) Proxy.newProxyInstance(
                personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new NonInvocationHandler(personBean));
    }

}
