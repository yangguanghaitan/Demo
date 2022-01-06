package guide.concurrent;

import java.text.SimpleDateFormat;
import java.util.Random;
/**
 * @Auther d
 * @Date 2022/1/6 17:43
 * @Describe 测试线程安全的ThreadLocal
 **/
public class ThreadLocalDemo implements Runnable{

    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));
//    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
//        @Override
//        protected SimpleDateFormat initialValue(){
//            return new SimpleDateFormat("yyyyMMdd HHmm");
//        }
//    };

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalDemo obj = new ThreadLocalDemo();
        for(int i=0 ; i<3; i++){
            Thread t = new Thread(obj, ""+i);
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toPattern());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat("yyyyMMdd"));

        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
    }

}

