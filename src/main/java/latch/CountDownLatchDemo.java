package latch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    static class TaskThread extends Thread {

        CountDownLatch latch;

        public TaskThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {

            try {
                System.out.println("1111111111");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(getName() + " Task is Done");
                latch.countDown();

            }


        }

    }

    public static void main(String[] args) throws InterruptedException {

        int threadNum = 10;
        CountDownLatch latch = new CountDownLatch(threadNum);
        for(int i = 0; i < threadNum; i++) {

            TaskThread task = new TaskThread(latch);
            task.start();
        }

        System.out.println("Task Start!");
        latch.await();

        System.out.println("All Task is Done!");
    }

}
