package guide.proxy.dynamicProxy.jdkDynamicProxy;

import guide.proxy.staicProxy.SmsService;

public class SmsServiceImpl implements SmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}

