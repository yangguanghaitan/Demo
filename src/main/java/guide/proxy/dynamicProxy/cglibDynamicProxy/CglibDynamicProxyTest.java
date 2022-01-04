package guide.proxy.dynamicProxy.cglibDynamicProxy;

public class CglibDynamicProxyTest {
    public static void main(String[] args) {

        AliSmsService aliSmsServiceProxy = (AliSmsService)CglibProxyFactory.getProxy(AliSmsService.class);
        String result = aliSmsServiceProxy.send("java");
    }
}
