package proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 步骤一: 创建InvocationHandler类。这个类与Proxy互相配合。遵循单一职责。Proxy负责动态生成代理对象。而InvocationHandler则是实现业务逻辑
 * 个人代理对象: 允许获取和设计自己属性
 */
public class OwnerInvocationHandler implements InvocationHandler {
    PersonBean personBean ;
    public OwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    /**
     * 业务上的增加实现。
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("get")) {
            return method.invoke(personBean, args);
        } else if (method.getName().equals("setHotOrNotRating")) {
            throw new IllegalAccessException();
        } else if (method.getName().startsWith("set")) {
            return method.invoke(personBean, args);
        }
        return null;
    }
}
