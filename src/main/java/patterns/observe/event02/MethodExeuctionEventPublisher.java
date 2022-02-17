package patterns.observe.event02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther d
 * @Date 2022/2/17 16:06
 * @Describe 事件源，类似于被观察者;本例有两个事件源，一个是{@link MethodExeuctionEventPublisher}类本身
 *            还有一个是"methodToMonitor"方法名.
 **/
public class MethodExeuctionEventPublisher {
    //维护观察者的一个列表
    private List<MethodExecutionEventListener> listeners = new ArrayList<MethodExecutionEventListener>();

    public void methodToMonitor() throws InterruptedException {
        MethodExecutionEventObject event = new MethodExecutionEventObject(this, "methodToMonitor");
        publishEvent(MethodExecutionStatus.BEGIN, event);
        // 执行实际的方法逻辑
        System.out.println("方法开始执行5秒钟！");
        Thread.sleep(5000);
        // ...
        publishEvent(MethodExecutionStatus.END, event);
    }

    protected void publishEvent(String status,MethodExecutionEventObject methodExecutionEvent) {
        //监听者
        List<MethodExecutionEventListener> copyListeners = new ArrayList<MethodExecutionEventListener>(listeners);
        for (MethodExecutionEventListener listener : copyListeners) {
            if (MethodExecutionStatus.BEGIN.equals(status))
                //告知监听者
                listener.onMethodBegin(methodExecutionEvent);
            else
                //告知监听者
                listener.onMethodEnd(methodExecutionEvent);
        }
    }
    //往观察者列表添加观察者
    public void addMethodExecutionEventListener(MethodExecutionEventListener listener) {
        this.listeners.add(listener);
    }
    //往观察者列表去除观察者
    public void removeListener(MethodExecutionEventListener listener) {
        if (this.listeners.contains(listener))
            this.listeners.remove(listener);
    }
    public void removeAllListeners() {
        this.listeners.clear();
    }
}