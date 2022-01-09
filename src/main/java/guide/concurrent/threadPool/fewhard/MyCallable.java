package guide.concurrent.threadPool.fewhard;

/**
 * @Auther d
 * @Date 2022/1/10 3:09
 * @Describe
 **/

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //返回执行当前 Callable 的线程名字
        return Thread.currentThread().getName();
    }
}

