
import cn.hutool.http.GlobalHeaders;
import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author d
 * @date 2022/1/10 2:26
 * @Describe
 **/
public class AllTest {


    public static void main(String[] args) throws Exception {

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
     * @date 2022/3/25 17:08
     * @Describe 位运算
     **/
    @Test
    public  void dd() {
        System.out.println(6 >> 1);//110->011->3
        System.out.println((36 & 1) == 0);//都为1才是1 true
        System.out.println((3 | 5) == 7);//都为0才是0  true
        System.out.println(1 << 4);//2的4次幂
        System.out.println("1 << 30=="+(1 << 30));//2的30次幂
        System.out.println("1<<16=="+(1 << 16));//2的16次幂

    }


    /**
     * @author d
     * @date 2022/3/25 17:06
     * @Describe 正则
     **/
    @Test
    public  void cc() {
        Pattern p = Pattern.compile("^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$");
        Matcher m = p.matcher("zhangsan-001@gmail.com");
        boolean result = m.matches();
        System.out.println(result);
    }

    /**
     * @author d
     * @date 2022/3/25 17:05
     * @Describe null的!=判断
     **/
    @Test
    public  void bb() {
        String str=null;
        System.out.println(str != null);
        System.out.println(null != str);
    }

    /**
     * @author d
     * @date 2022/1/11 1:53
     * @Describe retry:使用
     **/
    @Test
    public  void aa() {
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

    /**
     * @author d
     * @date 2022/3/26 16:19
     * @Description 杂乱
     **/
    @Test
    public  void a(){
        for (int binCount = 0; ; ++binCount);//死循环
    }
}
