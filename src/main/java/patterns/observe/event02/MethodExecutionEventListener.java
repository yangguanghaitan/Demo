package patterns.observe.event02;

import java.util.EventListener;

/**
 * @Auther d
 * @Date 2022/2/17 15:53
 * @Describe 监听器接口
 **/
public interface MethodExecutionEventListener extends EventListener {
    //开始执行监听
    void onMethodBegin(MethodExecutionEventObject evt);
    //执行结束监听
    void onMethodEnd(MethodExecutionEventObject evt);
}
