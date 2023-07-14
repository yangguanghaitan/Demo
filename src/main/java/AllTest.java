
import cn.hutool.http.GlobalHeaders;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author d
 * @date 2022/1/10 2:26
 * @Describe
 **/
public class AllTest {


    public static void main(String[] args) throws Exception {
      /*  List list=new ArrayList();
        int i=0;
        while (true){
         i++;
         list.add(1);
        }*/

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
//        GlobalHeaders.INSTANCE.headers();
//        GlobalHeaders.values();


        for (int i = 0; i < 10; i++) {
            if (i==3){
                break;
            }
            System.out.println(i);
        }
        System.out.println("ddd");


    }

    @Test
    public void test(){
        System.out.print("11\n");
        System.out.print("22");
    }



    /**
     * @author d
     * @date 2023/7/14 14:34
     * @Description  测试null的情况
     **/
    @Test
    public void hh(){
        int bb=getValue();//报异常
        System.out.println(getValue()+1);//报异常

    }
    public Integer getValue(){
        return null;
    }

    /**
     * @author d
     * @date 2023/4/10 17:19
     * @Description 测试commons-lang3的线程工厂
     **/
    @Test
    public void gg(){
//        ThreadFactory namedThreadFactory = new
        String aa1 = String.join("-", "ggThreadPool", "%s");
        BasicThreadFactory namedThreadFactory = new BasicThreadFactory.Builder().namingPattern(aa1).build();

        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
          pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        }
        pool.shutdown();
    }

    /**
     * @author d
     * @date 2022/6/11 20:06
     * @Description Vector集合的遍历是否有序
     **/
    @Test
    public void ff(){
        Vector<String> t=new Vector<String>();
        t.add("F");
        t.add("o");
        t.add("r");
        t.add("e");
        t.add("v");
        t.add("e");
        t.add("r");
        //第一种
        for (String string : t) {
            System.err.print(string);
        }
        //第二种
        t.forEach(new Consumer<String>() {
            @Override
            public void accept(String t) {
                // TODO Auto-generated method stub
                System.out.print(t);
            }
        });
        //第三种
        for (int i = 0; i < t.size(); i++) {
            System.out.print(t.get(i));
        }
        //第四种
        Iterator<String> it = t.iterator();
        while (it.hasNext()) {
            String string = (String) it.next();
            System.err.print(string);
        }
        //第五种
        Enumeration<String> enume = t.elements();
        while(enume.hasMoreElements()){
            System.out.print(enume.nextElement().toString());
        }

    }

    /**
     * @author d
     * @date 2022/4/13 7:46
     * @Description while 为true时会一直循环下去
     **/
    @Test
    public void ee(){
        int x = 10;
        do{
            System.out.println("value of x : " + x );
            x++;
        }while( x < 20 );
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
