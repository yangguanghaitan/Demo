package jvm;

import java.io.UnsupportedEncodingException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;


public class jvmTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        System.out.println(jvm.SubClass.valuek);
//        jvm.SuperClass[] superClasses=new jvm.SuperClass[10];

        byte[] b=new byte[]{  72, 101, 108, 108, 111, 32, 82, 111, 99, 107, 101, 116, 77, 81, 32, 48};
        String st=new String(b);
        System.out.println(st);
        String s="please_rename_unique_group_name";
        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));


        /*for (int i = 0; i < 10; i++) {
            System.out.println(Math.max(10000, Math.min(1000 * 30, 60000))/1000);
        }*/
   /*     HashSet set = new HashSet();
        set.add("1");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
                iterator.next();
                iterator.remove();

        }
        System.out.println(set.toString());*/
    /*    ArrayList list=new ArrayList();
        list.add("asd");
        list.add("看");
        list.add("的角色v吧");
        list.add("a受到了科举考试");
         setKeys(list);*/
//        String localAddress = getLocalAddress();
//        System.out.println(localAddress);
    }

    /*public static void setKeys(Collection<String> keys) {
        StringBuffer sb = new StringBuffer();
        for (String k : keys) {
            sb.append(k);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }*/
    public static String getLocalAddress() {
        try {
            // Traversal Network interface to get the first non-loopback and non-private address
            Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
            ArrayList<String> ipv4Result = new ArrayList<String>();
            ArrayList<String> ipv6Result = new ArrayList<String>();
            while (enumeration.hasMoreElements()) {
                final NetworkInterface networkInterface = enumeration.nextElement();
                final Enumeration<InetAddress> en = networkInterface.getInetAddresses();
                while (en.hasMoreElements()) {
                    final InetAddress address = en.nextElement();
                    if (!address.isLoopbackAddress()) {
                        if (address instanceof Inet6Address) {
                            ipv6Result.add(normalizeHostAddress(address));
                        } else {
                            ipv4Result.add(normalizeHostAddress(address));
                        }
                    }
                }
            }

            // prefer ipv4
            if (!ipv4Result.isEmpty()) {
                for (String ip : ipv4Result) {
                    if (ip.startsWith("127.0") || ip.startsWith("192.168")) {
                        continue;
                    }

                    return ip;
                }

                return ipv4Result.get(ipv4Result.size() - 1);
            } else if (!ipv6Result.isEmpty()) {
                return ipv6Result.get(0);
            }
            //If failed to find,fall back to localhost
            final InetAddress localHost = InetAddress.getLocalHost();
            return localHost+"";
        } catch (Exception e) {
//            log.error("Failed to obtain local address", e);
        }

        return null;
    }
    public static String normalizeHostAddress(final InetAddress localHost) {
        if (localHost instanceof Inet6Address) {
            return "[" + localHost.getHostAddress() + "]";
        } else {
            return localHost.getHostAddress();
        }
    }
    public static void hhh(AA as){
        as.getName();
        System.out.println(as);
    }
}

class SuperClass {
    static {
        System.out.println("jvm.SuperClass init");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("jvm.SubClass init");
    }

    public static int valuek = 123;
}
