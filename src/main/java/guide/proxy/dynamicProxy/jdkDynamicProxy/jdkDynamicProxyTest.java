package guide.proxy.dynamicProxy.jdkDynamicProxy;


import guide.proxy.staicProxy.SmsService;

public class jdkDynamicProxyTest {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsService smsServiceProxy = (SmsService)JdkProxyFactory.getProxy(smsService);//获取代理对象
        smsServiceProxy.send("java");
    }
}
