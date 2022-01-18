package guide.concurrent.AQS;

import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Auther d
 * @Date 2022/1/14 21:29
 * @Describe CycliBarrier是基于 ReentrantLock(ReentrantLock 也属于 AQS {@link AbstractQueuedSynchronizer})
 * 和 Condition.本例测试{@link CyclicBarrier#CyclicBarrier(int)}
 *
 **/
public class CyclicBarrierExample2 {
    private static final int threadCount = 6;
    // 需要同步的线程数量
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }

    public static void test(int threadnum) throws InterruptedException, BrokenBarrierException {
        System.out.println("threadnum:" + threadnum + "is ready");
        try {
            /**等待60秒，保证子线程完全执行结束*/
            cyclicBarrier.await(6, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("-----CyclicBarrierException------");
        }
        System.out.println("threadnum:" + threadnum + "is finish");
    }

}

