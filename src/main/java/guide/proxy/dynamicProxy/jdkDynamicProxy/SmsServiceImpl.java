package guide.proxy.dynamicProxy.jdkDynamicProxy;


public class SmsServiceImpl implements SmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}

