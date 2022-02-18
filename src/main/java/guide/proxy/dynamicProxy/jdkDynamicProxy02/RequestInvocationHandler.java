package guide.proxy.dynamicProxy.jdkDynamicProxy02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther d
 * @Date 2022/2/18 15:37
 * @Describe
 **/
public class RequestInvocationHandler implements InvocationHandler {
    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public RequestInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("request")) {
            //对符合条件的目标对象的方法进行增强
            System.out.println(target.getClass() + "类的request()方法马上要执行了");
        }
        Object result = method.invoke(target, args);
        if (method.getName().equals("request")) {
            //对符合条件的目标对象的方法进行增强
            System.out.println(target.getClass() + "类的request()方法执行结束了");
        }
        return null;
    }
}
