package guide.proxy.dynamicProxy.jdkDynamicProxy02;

import guide.proxy.dynamicProxy.jdkDynamicProxy02.One.OneRequest;
import guide.proxy.dynamicProxy.jdkDynamicProxy02.One.OneRequestImpl;
import guide.proxy.dynamicProxy.jdkDynamicProxy02.two.TwoRequest;
import guide.proxy.dynamicProxy.jdkDynamicProxy02.two.TwoRequestImpl;

/**
 * @Auther d
 * @Date 2022/2/18 15:30
 * @Describe 使用jdk动态代理为相同的两个Pointcut切点创建代理类，静态代理则需要创建两个代理类
 **/
public class jdkDynamicProxyTest {
    public static void main(String[] args) {
        //第一个目标对象
        OneRequest oneRequest = new OneRequestImpl();
        OneRequest oneRequestProxy = (OneRequest) JdkProxyFactory.getProxy(oneRequest);
        oneRequestProxy.request();
        System.out.println("############分隔符################");
        //第二个目标对象
        TwoRequest twoRequest = new TwoRequestImpl();
        TwoRequest twoRequestProxy = (TwoRequest) JdkProxyFactory.getProxy(twoRequest);
        twoRequestProxy.request();

    }
}
