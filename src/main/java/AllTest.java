
import cn.hutool.http.GlobalHeaders;
import cn.hutool.http.Header;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;

/**
 * @author d
 * @date 2022/1/10 2:26
 * @Describe
 **/
public class AllTest {


    public static void main(String[] args) throws Exception {
        /*System.out.println(6 >> 1);//110->011->3
        System.out.println((36&1)==0);//都为1才是1 true
        System.out.println((3|5)==7);//都为0才是0  true*/

      /*  RandomAccessFile rw = new RandomAccessFile(new File("asd.txt"), "rw");
        FileChannel channel = rw.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1*200);
        byte[] a=new byte[]{80,81,82,83,84};
//        map.put(a,1,4);
        byte aa=90;//P
        map.put(5,aa);*/

   /*     Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(9090);
        int a=7/0;
        System.out.println(8989);*/

        /*ReentrantLock lock=new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    Thread.sleep(90000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"aaa").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1111111111);
                lock.lock();
                try {
                    Thread.sleep(90000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"bbb").start();*/
        GlobalHeaders.INSTANCE.headers();
        GlobalHeaders.values();
    }


    /**
     * @author d
     * @date 2022/1/11 1:53
     * @Describe retry:使用
     **/
    public static void aa() {
        retry:
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if (i == 1) {
                System.out.println(88);
                continue retry; //本次循环，继续下次循环
            }
            if (i == 2)
              break retry;//跳出循环，往下执行

        }
        System.out.println(99);
    }

}
