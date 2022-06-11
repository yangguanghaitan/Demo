package patterns.observe.observe01;

/**
 * @Auther d
 * @Date 2022/6/11 17:27
 * @Describe 主题，观察者会注册到主题上，主题发生变更就会通知注册的观察者
 **/
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
