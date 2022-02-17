package patterns.observe.event02;

/**
 * @Auther d
 * @Date 2022/2/17 15:53
 * @Describe java的事件模型通知程序，类似于观察者模式
 *           本例:方法的执行情况进行发布和监听
 **/
public class EventObserveDemo02 {
    public static void main(String[] args) throws InterruptedException {
        //监听者
        SimpleMethodExecutionEventListener listener = new SimpleMethodExecutionEventListener();
        //事件源
        MethodExeuctionEventPublisher eventPublisher = new MethodExeuctionEventPublisher();
        eventPublisher.addMethodExecutionEventListener(listener);
        //发布事件
        eventPublisher.methodToMonitor();

    }
}
