package guide.concurrent.threadPool;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther d
 * @Date 2022/1/7 2:05
 * @Describe
 **/
public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 2;
    private static final int MAX_POOL_SIZE = 4;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;
    public static void main(String[] args) {

        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 6; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new MyRunnable("" + i);
            //执行Runnable
            executor.execute(worker);
        }
        boolean shutdown = executor.isShutdown();
        boolean terminated = executor.isTerminated();
        boolean terminating = executor.isTerminating();

        //终止线程池
        executor.shutdown();

        boolean shutdown1 = executor.isShutdown();
        boolean terminated2 = executor.isTerminated();
        boolean terminating3 = executor.isTerminating();
        while (!executor.isTerminated()) {
//            System.out.println("executor is not Terminated");
        }
        System.out.println("Finished all threads");
    }
}

