package guide.proxy.dynamicProxy.cglibDynamicProxy02;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther d
 * @Date 2022/2/18 16:16
 * @Describe
 **/
public class RequestMethodInterceptor implements MethodInterceptor {
    /**
     * @param o           代理对象（增强的对象）
     * @param method      被拦截的方法（需要增强的方法）
     * @param args        方法入参
     * @param methodProxy 用于调用原始方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("request")) {
            //对符合条件的目标对象的方法进行增强
            System.out.println(o.getClass() + "类的request()方法马上要执行了");
        }
        Object object = methodProxy.invokeSuper(o, args);
        if (method.getName().equals("request")) {
            //对符合条件的目标对象的方法进行增强
            System.out.println(o.getClass() + "类的request()方法执行结束了");
        }
        return null;
    }
}
