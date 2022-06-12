package template.callback;

/**
 * 1.回调跟模板模式一样，也具有复用和扩展的功能.
 * 2.回调分为同步回调、异步回调(延迟回调)。
 *   同步回调指在函数返回之前执行回调函数、异步回调指的是在函数返回之后执行回调函数。
 * 3.从应用场景看，同步模式看起来更像模式模式，异步回调看起来更像观察者模式。
 */
public class AClass {
    public static void main(String[] args) {
        BClass b = new BClass();
        b.process(new ICallback() {
            @Override
            public void methodToCallback() {
                System.out.println("method call back.");
            }
        });
    }
}
