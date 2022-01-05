package guide.concurrent;

/**
 * @Auther d
 * @Date 2022/1/6 0:03
 * @Describe 测试static和非static方法的synchronized用法
 *           相同点:一直持有锁，直到临界方法(critical method)执行完毕.
 *           不同点:非static方法不同的对象调用不用等待,因为有多个锁。
 *           补充:static和非static方法可以被多线程同时调用，因为锁不同,访问静态 synchronized 方法占用的锁是当前类的锁，而访问非静态 synchronized 方法占用的锁是当前实例对象锁。
 **/
public class SynchronizedDemo {
    public synchronized static void printStatic() {
        System.out.println(Thread.currentThread().getName()+":aaaaaaaa");
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+":3秒过去了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printNotStatic() {
        System.out.println(Thread.currentThread().getName()+":bbbbbbb");
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+":3秒过去了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //测试非static和static方法
    public static void main(String[] args) {
        SynchronizedDemo demo=new SynchronizedDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizedDemo.printStatic();
            }
        },"线程1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.printNotStatic();
            }
        },"线程2").start();
    }


    /*//测试非static方法
    public static void main(String[] args) {
        SynchronizedDemo demo=new SynchronizedDemo();
        SynchronizedDemo demo2=new SynchronizedDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.printNotStatic();

            }
        },"线程1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.printNotStatic();
            }
        },"线程2").start();
    }*/




    /*//测试static方法
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizedDemo.printStatic();

            }
        },"线程1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizedDemo.printStatic();
            }
        },"线程2").start();
    }*/
}
