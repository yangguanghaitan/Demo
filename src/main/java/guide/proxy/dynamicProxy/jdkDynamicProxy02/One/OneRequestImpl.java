package guide.proxy.dynamicProxy.jdkDynamicProxy02.One;

/**
 * @Auther d
 * @Date 2022/2/18 15:33
 * @Describe
 **/
public class OneRequestImpl implements OneRequest{
    @Override
    public void request() {
        System.out.println("OneRequestImpl的request()方法执行了");
    }
}
