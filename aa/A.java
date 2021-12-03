import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.time.temporal.TemporalAdjusters.lastInMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class A {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executor = Executors.newWorkStealingPool();
//        List<Callable<String>> callables = Arrays.asList(
//                () -> "task1",
//                () -> "task2",
//                () -> "task3");
//        executor.invokeAll(callables)
//                .stream()
//                .map(future -> {
//                    try {
//                        return future.get();
//                    }
//                    catch (Exception e) {
//                        throw new IllegalStateException(e);
//                    }
//                })
//                .forEach(System.out::println);

//        ExecutorService executor = Executors.newWorkStealingPool();
//
//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
//        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);
//        TimeUnit.MILLISECONDS.sleep(1337);
//        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
//        System.out.printf("Remaining Delay: %sms", remainingDelay);
//        ReentrantLock lock = new ReentrantLock();
//        executor.submit(() -> {
//            lock.lock();
//            try {
//                sleep(1);
//            } finally {
//                lock.unlock();
//            }
//        });
//        executor.submit(() -> {
//            sleep(2);
//            System.out.println("Locked: " + lock.isLocked());
//            System.out.println("Held by me: " + lock.isHeldByCurrentThread());
//            boolean locked = lock.tryLock();
//            System.out.println("Lock acquired: " + locked);
//        });
//        stop(executor);

//        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
//        map.put("foo", "bar");
//        map.put("han", "solo");
//        map.put("r2", "d2");
//        map.put("c3", "p0");
//        map.replaceAll((key, value) -> "r2".equals(key) ? "d3" : value);
//        System.out.println(map.get("r2"));
//        map.forEach((key, value) -> System.out.printf("%s = %s\n", key, value));
//        System.out.println(ForkJoinPool.getCommonPoolParallelism());
//        List list=new ArrayList();
        // Lambda表达式的书写形式
        Runnable run = () -> System.out.println("Hello World");// 1
        run.run();
        ActionListener listener = event -> System.out.println("button clicked");// 2
        Runnable multiLine = () -> {// 3 代码块
            System.out.print("Hello");
            System.out.println(" Hoolee");
        };
//        multiLine.run();
        BinaryOperator<Long> add = (Long x, Long y) -> x + y;// 4
        Long apply = add.apply(3L, 4L);
        System.out.println(apply);
        BinaryOperator<Long> addImplicit = (x, y) -> x + y;// 5 类型推断
    }

    public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }
    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }


}
