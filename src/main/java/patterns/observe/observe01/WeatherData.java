package patterns.observe.observe01;

import java.util.ArrayList;

/**
 * @Auther d
 * @Date 2022/6/11 17:36
 * @Describe 具体的主题，天气主题，当从气象站获取新的测量数据时，就需要通知订阅主题的观察者们了
 **/
public class WeatherData implements Subject {
    //观察者列表
    private ArrayList<Observer> observers;

    private float temp;//温度
    private float humidity;//湿度
    private float pressure;//压强

    public WeatherData() {
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temp,humidity,pressure);
        }
    }

    //当从气象站获取新的测量数据时，就需要通知订阅主题的观察者们了
    public void measurementsChanged(){
        notifyObservers();
    }

    //从气象站获取最新数据
    public void setMeasurements(float temp,float humidity,float pressure){
        this.temp=temp;//温度
        this.humidity=humidity;//湿度
        this.pressure=pressure;//压强
        measurementsChanged();
    }
}
