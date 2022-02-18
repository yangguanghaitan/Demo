package guide.proxy.dynamicProxy.cglibDynamicProxy02;

import com.sun.corba.se.impl.corba.RequestImpl;
import guide.proxy.dynamicProxy.cglibDynamicProxy02.One.OneRequestImpl;
import guide.proxy.dynamicProxy.cglibDynamicProxy02.two.TwoRequestImpl;

/**
 * @Auther d
 * @Date 2022/2/18 16:15
 * @Describe 借助Cglib动态字节码生成库，在程序运行期间动态的为目标对象生成相应的扩展子类
 **/
public class CglibDynamicProxyTest {
    public static void main(String[] args) {
        //第一个目标对象
        OneRequestImpl oneRequestImplProxy = (OneRequestImpl) CglibProxyFactory.getProxy(OneRequestImpl.class);
        oneRequestImplProxy.request();
        System.out.println("############分隔符################");
        //第二个目标对象
        TwoRequestImpl twoRequestImplProxy = (TwoRequestImpl) CglibProxyFactory.getProxy(TwoRequestImpl.class);
        twoRequestImplProxy.request();
    }
}
