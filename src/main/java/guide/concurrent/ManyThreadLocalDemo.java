package guide.concurrent;

/**
 * @Auther d
 * @Date 2022/1/6 21:41
 * @Describe 测试一个线程多个ThreadLocal对象
 *           说明:Thread内部有一个{@link ThreadLocal.ThreadLocalMap}的属性，
 *                ThreadLocalMap维护了一个{@link java.lang.ThreadLocal.ThreadLocalMap.Entry}类型的数组，
 *                每个元素存放一个变量,这样就实现了一个线程保存多个变量的副本，获取时，根据线程对象
 *                获取ThreadLocal.ThreadLocalMap变量，然后在Entry数组中根据计算出index找到对应的
 *                Entry，entry.value得到值。
 *
 *                 ThreadLocal内存泄露:class Entry extends WeakReference<ThreadLocal<?>>,
 *                 ThreadLocalMap 中使用的 key 为 ThreadLocal 的弱引用,而 value 是强引用
 *
 *                 弱引用可以和一个引用队列（ReferenceQueue）联合使用，如果弱引用所引用的对象被垃圾回收，
 *                 Java 虚拟机就会把这个弱引用加入到与之关联的引用队列中。
 *
 **/
public class ManyThreadLocalDemo implements Runnable{
    private static ThreadLocal<String> local1=new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "aaaa";
        }
    };
    private static ThreadLocal<String> localb=new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "bbbb";
        }
    };

    public static void main(String[] args) {
        ManyThreadLocalDemo demo=new ManyThreadLocalDemo();
        Thread t=new Thread(demo,"线程name");
        t.start();
    }

    /**
     * @author d
     * @date 2022/1/6 22:24
     * @Describe 拿不到 thread.threadLocals变量，修饰符的原因
     *         Thread thread = Thread.currentThread();
     *         thread.threadLocals
     **/
    @Override
    public void run() {
        String locala = local1.get();
        System.out.println("本线程变量1: "+locala);
        String localbb = localb.get();
        System.out.println("本线程变量2: "+localbb);
        Thread thread = Thread.currentThread();
    }
}
