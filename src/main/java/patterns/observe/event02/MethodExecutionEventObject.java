package patterns.observe.event02;

import java.util.EventObject;

/**
 * @Auther d
 * @Date 2022/2/17 15:48
 * @Describe 事件
 **/
public class MethodExecutionEventObject extends EventObject {

    //事件源，类似于被观察者
    private String methodName;

    public MethodExecutionEventObject(Object source) {
        super(source);
    }

    public MethodExecutionEventObject(Object source, String methodName) {
        super(source);
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
