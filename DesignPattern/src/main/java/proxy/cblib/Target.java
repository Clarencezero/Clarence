package proxy.cblib;

public class Target {
    public void targetMethod(String s1) {
        System.out.println(String.format("当前Classloader%s, 方法参数: %s", this.getClass().getClassLoader(),  s1));
    }
}
