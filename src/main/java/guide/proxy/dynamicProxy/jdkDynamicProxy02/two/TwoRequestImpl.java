package guide.proxy.dynamicProxy.jdkDynamicProxy02.two;

/**
 * @Auther d
 * @Date 2022/2/18 15:35
 * @Describe
 **/
public class TwoRequestImpl implements TwoRequest {
    @Override
    public void request() {
        System.out.println("twoRequestImpl的request()方法执行了");
    }
}
