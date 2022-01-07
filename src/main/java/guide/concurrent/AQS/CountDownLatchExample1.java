package guide.concurrent.AQS;

import utils.Constrants;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Auther d
 * @Date 2022/1/8 3:31
 * @Describe AQS 是一个用来构建锁和同步器的框架
 *           CountDownLatch也是基于Aqs{@link AbstractQueuedSynchronizer}
 **/
public class CountDownLatchExample1 {
    // 处理文件的数量
    private static final int threadCount = 9;

    public static void main(String[] args) throws InterruptedException {
        // 创建一个具有固定线程数量的线程池对象（推荐使用构造方法创建）
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        //开始时间，保留精度
        long begin = System.currentTimeMillis();
        BigDecimal begin1=new BigDecimal(begin+"");

        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            threadPool.execute(() -> {
                try {
                    //处理文件的业务操作
                    //......
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //表示一个文件已经被完成
                    countDownLatch.countDown();
                }

            });
        }
        countDownLatch.await();
        //结束时间，保留精度
        long end = System.currentTimeMillis();
        BigDecimal end1=new BigDecimal(end+"");
        System.out.println("耗时:"+(end1.subtract(begin1).divide(new BigDecimal("1000"))+"秒"));

        threadPool.shutdown();
        System.out.println("finish");
    }
}

