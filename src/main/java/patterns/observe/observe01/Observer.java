package patterns.observe.observe01;

/**
 * @Auther d
 * @Date 2022/6/11 17:27
 * @Describe 观察者,会注册到主题上，主题发生变更就会通观察者
 **/
public interface Observer {
    //温度，湿度，压强
    void update(float temp,float humidity,float pressure);
}
