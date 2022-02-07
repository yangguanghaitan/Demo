package net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @Auther d
 * @Date 2022/2/6 15:32
 * @Describe 测试网络类，ping命令获取索引:netsh int ipv4 show interfaces{@code mac1}
 **/
public class InetAddressDemo {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("192.168.1.123");
        //获取主机名
        System.out.println(address.getHostName());

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost.getHostAddress());
        System.out.println(localHost.getCanonicalHostName());
        System.out.println(localHost);

//        SecurityManager securityManager=new SecurityManager();
//        securityManager.checkConnect("www.baidu.com",-1);
        System.out.println("===");

        InetAddress ia = InetAddress.getLocalHost();
        //方法一:获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
        byte[] mac = NetworkInterface.getByInetAddress(address).getHardwareAddress();
        //方法二：查找网络接口,根据索引
        byte[] mac1 = NetworkInterface.getByIndex(12).getHardwareAddress();
        //下面代码是把mac地址拼装成String
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mac1.length; i++) {
            if (i != 0)sb.append("-");
            //mac[i] & 0xFF 是为了把byte转化为正整数
            String s = Integer.toHexString(mac[i] & 0xFF);
            sb.append(s.length() == 1 ? 0 + s : s);
        }
        System.out.println(sb.toString().toUpperCase());
    }
}
