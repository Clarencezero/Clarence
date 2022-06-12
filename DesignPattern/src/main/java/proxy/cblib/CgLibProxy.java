

import java.lang.reflect.Method;

//public class CgLibProxy implements MethodInterceptor {
//    @Override
//    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//        beforeMethod(args);
//        Object result = proxy.invokeSuper(o, args);
//        afterMethod(args);
//        return result;
//    }
//
//    public void beforeMethod(Object[] args) {
//        System.out.println("Aop 前置 参数校验");
//        if (args.length != 1) {
//            throw new IllegalArgumentException("只允许有一个参数");
//        }
//        args[0] = "参数校验成功: " + args[0];
//    }
//
//    public void afterMethod(Object[] args) {
//        System.out.println("Aop 后置 增强操作!");
//    }
//}
