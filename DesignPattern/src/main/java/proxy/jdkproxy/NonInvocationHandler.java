package proxy.jdkproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 步骤一: 创建InvocationHandler类
 */
public class NonInvocationHandler implements InvocationHandler {
    PersonBean personBean;

    public NonInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("get")) {
            return method.invoke(personBean, args);
        } else if (method.getName().equals("setHotOrNotRating")) {
            method.invoke(personBean, args);
        } else if (method.getName().startsWith("set")) {
            throw new IllegalAccessException();
        }
        return null;
    }
}
