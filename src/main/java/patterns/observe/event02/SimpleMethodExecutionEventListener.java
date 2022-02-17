package patterns.observe.event02;

/**
 * @Auther d
 * @Date 2022/2/17 15:58
 * @Describe 具体的监听器，类似于观察者
 **/
public class SimpleMethodExecutionEventListener implements MethodExecutionEventListener{
    @Override
    public void onMethodBegin(MethodExecutionEventObject evt) {
        String methodName = evt.getMethodName();
        System.out.println(methodName + "方法开始执行了");
    }

    @Override
    public void onMethodEnd(MethodExecutionEventObject evt) {
        String methodName = evt.getMethodName();
        System.out.println(methodName + "方法执行完毕了");
    }
}
